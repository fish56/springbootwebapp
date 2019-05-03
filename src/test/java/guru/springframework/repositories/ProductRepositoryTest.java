package guru.springframework.repositories;

import com.alibaba.fastjson.JSONObject;
import guru.springframework.SpringBootWebApplicationTests;
import guru.springframework.configuration.RepositoryConfiguration;
import guru.springframework.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ProductRepositoryTest extends SpringBootWebApplicationTests {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 就是测试通过jpa，对内存数据库进行增该查
    @Test
    public void save() {
        // 创建一个Product对象
        Product product = new Product();
        product.setDescription("Spring Framework Guru Shirt");
        product.setPrice(new BigDecimal("18.95"));
        product.setProductId("1234");

        // 开始，它的ID为null
        assertNull(product.getId());

        // 保存到数据库后，会获得自增主键
        productRepository.save(product);
        assertNotNull(product.getId());

        System.out.println(JSONObject.toJSONString(product));

        // 通过Crud方法再次读取数据
        Product fetchedProduct = productRepository.findById(product.getId()).orElse(null);
        assertNotNull(fetchedProduct);

        // 前后来个记录的id应该相等
        assertEquals(product.getId(), fetchedProduct.getId());
        assertEquals(product.getDescription(), fetchedProduct.getDescription());
    }

    @Test
    public void list(){

        // 确认数据库还是有且只有一条记录
        long productCount = productRepository.count();

        // 获得所有的记录
        Iterable<Product> products = productRepository.findAll();
        System.out.println(JSONObject.toJSONString(products));

        int count = 0;

        for(Product p : products){
            count++;
        }

        // 确认两个sql不矛盾
        assertEquals(count, productCount);
    }
}
