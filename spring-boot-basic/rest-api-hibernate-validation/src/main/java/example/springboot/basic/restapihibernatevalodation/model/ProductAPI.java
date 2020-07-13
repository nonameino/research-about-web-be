package example.springboot.basic.restapihibernatevalodation.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/products")
@Validated
public class ProductAPI {

    private final ProductService stock;

    @Autowired

    public ProductAPI(ProductService stock) {
        this.stock = stock;
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> findAll() {
        ResponseDTO responseDTO = ResponseDTO.builder()
                .status(HttpStatus.OK.toString())
                .body(stock.findAll()).build();
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> findById(@PathVariable @ProductIdExisting Long id) {
        ResponseDTO responseDTO = ResponseDTO.builder()
                .status(HttpStatus.OK.toString())
                .body(stock.findById(id)).build();
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> save(@RequestBody @Valid Product product) {
        ResponseDTO responseDTO = ResponseDTO.builder()
                .status(HttpStatus.CREATED.toString())
                .body(stock.save(product)).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> update(@PathVariable Long id, @RequestBody @Valid Product product) {
        ResponseDTO responseDTO = ResponseDTO.builder()
                .status(HttpStatus.ACCEPTED.toString())
                .body(stock.save(product)).build();
        return ResponseEntity.accepted().body(responseDTO);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<ResponseDTO> deleteById(@PathVariable @ProductIdExisting Long id) {
        stock.deleteById(id);
        ResponseDTO responseDTO = ResponseDTO.builder()
                .status(HttpStatus.ACCEPTED.toString()).build();
        return ResponseEntity.accepted().body(responseDTO);
    }
}
