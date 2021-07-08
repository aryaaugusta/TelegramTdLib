package com.edts.tdlib.util.uam;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Utility class for handling pagination.
 *
 * <p>
 * Pagination uses the same principles as the <a href="https://developer.github.com/v3/#pagination">GitHub API</a>,
 * and follow <a href="http://tools.ietf.org/html/rfc5988">RFC 5988 (Link header)</a>.
 */
public final class PaginationUtil {

    private PaginationUtil() {
    }

    public static <T> HttpHeaders generatePaginationHttpHeaders(Page<T> page, String baseUrl) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Count", Long.toString(page.getTotalElements()));
        String link = "";
        if ((page.getNumber() + 1) < page.getTotalPages()) {
            link = "<" + generateUri(baseUrl, page.getNumber() + 1, page.getSize()) + ">; rel=\"next\",";
        }
        // prev link
        if ((page.getNumber()) > 0) {
            link += "<" + generateUri(baseUrl, page.getNumber() - 1, page.getSize()) + ">; rel=\"prev\",";
        }
        // last and first link
        int lastPage = 0;
        if (page.getTotalPages() > 0) {
            lastPage = page.getTotalPages() - 1;
        }
        link += "<" + generateUri(baseUrl, lastPage, page.getSize()) + ">; rel=\"last\",";
        link += "<" + generateUri(baseUrl, 0, page.getSize()) + ">; rel=\"first\"";
        headers.add(HttpHeaders.LINK, link);
        return headers;
    }

    private static String generateUri(String baseUrl, int page, int size) {
        return UriComponentsBuilder.fromUriString(baseUrl).queryParam("page", page).queryParam("size", size).toUriString();
    }
    
    
    /**
     * Convert Page to PageData
     * 
     * @param page Page
     * @param baseUrl API base URL
     * @return PageData
     */
    public static <E> PageDataObj<E> convertPageToPageData(Page<E> page, String baseUrl) {
        return convertPageToPageData(page, baseUrl, new LinkedMultiValueMap<>());
    }
    
    /**
     * Convert Page to PageData
     * 
     * @param page Page
     * @param baseUrl API base URL
     * @param params additional parameter in query string
     * @return PageData
     */
    public static <E> PageDataObj<E> convertPageToPageData(Page<E> page, String baseUrl, MultiValueMap<String, String> params) {
        // Page number start from 0
        int next = page.getNumber() + 2;
        int prev = page.getNumber();
        int first = 1;
        int last = page.getPageable() == Pageable.unpaged() ? 0 : page.getTotalPages();
        
        boolean nextAvailable = first <= next && next <= last;
        String nextLink = nextAvailable ? generateUri(baseUrl, next, page.getSize(), params) : null;
        boolean prevAvailable = first <= prev && prev <= last;
        String prevLink = prevAvailable ? generateUri(baseUrl, prev, page.getSize(), params) : null;
        boolean firstAvailable = first <= last;
        String firstLink = firstAvailable ? generateUri(baseUrl, first, page.getSize(), params) : null;
        boolean lastAvailable = last > 0;
        String lastLink = lastAvailable ? generateUri(baseUrl, last, page.getSize(), params) : null;
        
        return new PageDataObj<E>()
                .data(page.getContent())
                .next(nextAvailable, nextLink)
                .prev(prevAvailable, prevLink)
                .first(firstAvailable, firstLink)
                .last(lastAvailable, lastLink);
    }
    
    private static String generateUri(String baseUrl, int page, int size, MultiValueMap<String, String> params) {
        return UriComponentsBuilder.fromUriString(baseUrl).queryParam("page", page).queryParam("size", size).queryParams(params).toUriString();
    }
    
    public static <T> HttpHeaders generateSearchPaginationHttpHeaders(String query, Page<T> page, String baseUrl) {
        String escapedQuery;
        escapedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Count", Long.toString(page.getTotalElements()));
        String link = "";
        if ((page.getNumber() + 1) < page.getTotalPages()) {
            link = "<" + generateUri(baseUrl, page.getNumber() + 1, page.getSize()) + "&query=" + escapedQuery + ">; rel=\"next\",";
        }
        // prev link
        if ((page.getNumber()) > 0) {
            link += "<" + generateUri(baseUrl, page.getNumber() - 1, page.getSize()) + "&query=" + escapedQuery + ">; rel=\"prev\",";
        }
        // last and first link
        int lastPage = 0;
        if (page.getTotalPages() > 0) {
            lastPage = page.getTotalPages() - 1;
        }
        link += "<" + generateUri(baseUrl, lastPage, page.getSize()) + "&query=" + escapedQuery + ">; rel=\"last\",";
        link += "<" + generateUri(baseUrl, 0, page.getSize()) + "&query=" + escapedQuery + ">; rel=\"first\"";
        headers.add(HttpHeaders.LINK, link);
        return headers;
    }    
    
    
}