package guru.springframework.services;

import guru.springframework.SpringBootWebApplicationTests;
import guru.springframework.configuration.RepositoryConfiguration;
import guru.springframework.domain.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ProductServiceImplTest extends SpringBootWebApplicationTests {
    @Autowired
    private ProductService productService;

    @Test
    public void getProductById() {
        // 创建一个Product对象
        Product product = new Product();
        product.setDescription("Spring Framework Guru Shirt");
        product.setPrice(new BigDecimal("18.95"));
        product.setProductId("1234");
        productService.saveProduct(product);

        Assert.assertNotNull(product.getId());

        // 确认查询功能
        Product fetchedProduct = productService.getProductById(product.getId());
        assertEquals(product.getId(), fetchedProduct.getId());

    }
}