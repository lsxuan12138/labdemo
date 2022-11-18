package com.school.entity;

public class StoreItem {
        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getStoreId() {
            return storeId;
        }
        public void setStoreId(Integer storeId) { this.storeId = storeId; }

        public Integer getProductId() {
            return productId;
        }
        public void setProductId(Integer productId) { this.productId = productId; }

        public Integer getQuantity() {
            return quantity;
        }
        public void setQuantity(Integer quantity) { this.quantity = quantity; }

        public Integer id;
        public Integer storeId;
        public Integer productId;
        public Integer quantity;
}
