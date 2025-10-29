package com.example.cardatabase4;

public class InventoryManager {
    public static <OutOfStockException> void main(String[] args) {
        Product laptop = new Product("노트북", 10);
        int orderQuantity = 15;


        try {
            System.out.println("제고 수량 확인");
        } catch (OutOfStockException e) {
            System.out.println("재고 부족: 15개 주문 불가. 현재 재고: 10개.");
        }
    }
}
