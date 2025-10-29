package com.example.cardatabase4;

public class Product {
    private String name;
    private int stock;

    public Product(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    public void decreaseStock(int quantity) throws OutOfStockException {
        // TODO: quantity가 stock보다 크면 OutOfStockException을 발생시키는 코드를 작성하시오.
        // 그렇지 않으면 stock을 quantity만큼 감소시킵니다.
    }

    public int getStock() {
        return stock;
    }
}
