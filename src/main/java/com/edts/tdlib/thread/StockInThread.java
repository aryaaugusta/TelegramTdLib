package com.edts.tdlib.thread;

//@Service
//public class StockInThread {
//
//    private final ProductRepository productRepository;
//    private final InventoryHistoryRepository inventoryHistoryRepository;
//    private final InventorySummaryRepository inventorySummaryRepository;
//    private final StockRepository stockRepository;
//
//    @Autowired
//    public StockInThread(ProductRepository productRepository, InventoryHistoryRepository inventoryHistoryRepository, InventorySummaryRepository inventorySummaryRepository, StockRepository stockRepository) {
//        this.productRepository = productRepository;
//        this.inventoryHistoryRepository = inventoryHistoryRepository;
//        this.inventorySummaryRepository = inventorySummaryRepository;
//        this.stockRepository = stockRepository;
//    }
//
//    @Async
//    public void productThread(Product product, BigDecimal costPrice, int qty) {
//        Date today = new Date();
//        product.setModifiedDate(today);
//        product.setCostPrice(costPrice);
//        product.setQty(qty);
//        productRepository.save(product);
//    }
//
//    @Async
//    public void stockThread(Stock stock, String type, String notes, String stockNo) {
//        stock.setType(type);
//        stock.setNotes(notes);
//        stock.setStockNo(stockNo);
//        stockRepository.save(stock);
//    }
//
//    public void inventoryThread(InventorySummary inventorySummary, Product product, int qty, BigDecimal costPrice, Stock stock) {
//        Date today = new Date();
//        InventoryHistory inventoryHistoryNew = new InventoryHistory();
//
//        BigDecimal avgCostPrice2;
//        BigDecimal avgCostPrice1;
//        BigDecimal avgCostPriceFinal;
//        BigDecimal result;
//        int pastQty = product.getQty();
//        BigDecimal pastCostPrice = product.getCostPrice();
//        avgCostPrice1 = pastCostPrice.multiply(new BigDecimal(pastQty));
//        avgCostPrice2 = costPrice.multiply(new BigDecimal(qty));
//
//        avgCostPriceFinal = avgCostPrice1.add(avgCostPrice2);
//        int qtyCalc = pastQty + qty;
//        result = avgCostPriceFinal.divide(new BigDecimal(qtyCalc), 2, RoundingMode.HALF_UP);
//        inventoryHistoryNew.setAvgCostPrice(result);
//
//        int productQuantity = product.getQty();
//        int qtyOnHand = inventorySummary.getQtyOnHand();
//        int qtyInAccum = inventorySummary.getQtyInAccum();
//        inventorySummary.setQtyOnHand(qtyOnHand + qty);
//        inventorySummary.setQtyInAccum(qtyInAccum + qty);
//        inventorySummary.setModifiedDate(today);
//
//        inventoryHistoryNew.setHistoryDate(today);
//        inventoryHistoryNew.setProduct(product);
//        inventoryHistoryNew.setType("STOCK_IN");
//        inventoryHistoryNew.setInventorySummary(inventorySummary);
//        inventoryHistoryNew.setQty(qty);
//        inventoryHistoryNew.setCostPrice(costPrice);
//        inventoryHistoryNew.setStock(stock);
//
//        productThread(product, result, productQuantity + qty);
//
//        inventorySummaryRepository.save(inventorySummary);
//
//        inventoryHistoryRepository.save(inventoryHistoryNew);
//    }
//}
