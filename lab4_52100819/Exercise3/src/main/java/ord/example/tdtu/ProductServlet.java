package ord.example.tdtu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;

import com.google.gson.Gson;
@WebServlet("/ProductService/*")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUTD = 1;
    private List<Product> products;
    @Override
    public void init() throws ServletException {
        super.init();
        products = new ArrayList<>();

        Product product1 = new Product("1", "Product 1",2000);
        Product product2 = new Product("2", "Product 2",3000);
        Product product3 = new Product("3", "Product 3", 4000);
        products.add(product1);
        products.add(product2);
        products.add(product3);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        Gson gson = new Gson();
        String id = request.getParameter("id");
        if(id == null){
            LinkedHashMap<String, Object> jsonResponse = new LinkedHashMap<>();
            jsonResponse.put("code", 0);
            jsonResponse.put("message", "Đọc sản phẩm thành công");
            jsonResponse.put("data", products);
            response.getWriter().println(gson.toJson(jsonResponse));
            return;
        }
        else{
            Product product = getProductById(id);
            if(product != null){
                LinkedHashMap<String, Object> jsonResponse = new LinkedHashMap<>();
                jsonResponse.put("code", 0);
                jsonResponse.put("message", "Đọc sản phẩm thành công");
                jsonResponse.put("data", product);
                response.getWriter().println(gson.toJson(jsonResponse));
                return;
            }
            else{
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                LinkedHashMap<String, Object> jsonResponse = new LinkedHashMap<>();
                jsonResponse.put("code", 2);
                jsonResponse.put("message", "Không tìm thấy sản phầm naò có mã số " + id);
                response.getWriter().println(gson.toJson(jsonResponse));
                return;
            }

        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("application/json");
        Gson gson = new Gson();
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String price = request.getParameter("price");

        if(id == null || name == null || price == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            LinkedHashMap<String, Object> jsonResponse = new LinkedHashMap<>();
            jsonResponse.put("code", 2);
            jsonResponse.put("message", "Thiếu tham số");
            response.getWriter().println(gson.toJson(jsonResponse));
            return;
        }
        int productPrice = 0;
        try {
            productPrice = Integer.parseInt(price) ;

        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            LinkedHashMap<String, Object> jsonResponse = new LinkedHashMap<>();
            jsonResponse.put("code", 2);
            jsonResponse.put("message", "Sai format");
            response.getWriter().println(gson.toJson(jsonResponse));
            return;
        }
        if(getProductById(id) != null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            LinkedHashMap<String, Object> jsonResponse = new LinkedHashMap<>();
            jsonResponse.put("code", 2);
            jsonResponse.put("message", "Sản phầm đã tồn tại");
            response.getWriter().println(gson.toJson(jsonResponse));
            return;
        }

        Product  newProduct = new Product(id,name,productPrice);
        products.add(newProduct);
        response.setStatus(HttpServletResponse.SC_CREATED);
        LinkedHashMap<String, Object> jsonResponse = new LinkedHashMap<>();
        jsonResponse.put("code", 0);
        jsonResponse.put("message", "Thêm một sản phẩm thành công có id: " + id);
        jsonResponse.put("data", newProduct);
        response.getWriter().println(gson.toJson(jsonResponse));

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("application/json");
        Gson gson = new Gson();
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        if(id == null || name == null || price == null){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            LinkedHashMap<String, Object> jsonResponse = new LinkedHashMap<>();
            jsonResponse.put("code", 2);
            jsonResponse.put("message", "Thiếu tham số");;
            response.getWriter().println(gson.toJson(jsonResponse));
            return;
        }
        int productPrice = 0;
        try {
            productPrice = Integer.parseInt(price) ;

        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            LinkedHashMap<String, Object> jsonResponse = new LinkedHashMap<>();
            jsonResponse.put("code", 2);
            jsonResponse.put("message", "Sai format");
            response.getWriter().println(gson.toJson(jsonResponse));
            return;
        }
        Product existingProduct = getProductById(id);
        if(existingProduct == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            LinkedHashMap<String, Object> jsonResponse = new LinkedHashMap<>();
            jsonResponse.put("code", 2);
            jsonResponse.put("message", "Sản phầm không tồn tại");
            response.getWriter().println(gson.toJson(jsonResponse));
            return;
        }
        existingProduct.setName(name);
        existingProduct.setPrice(productPrice);
        LinkedHashMap<String, Object> jsonResponse = new LinkedHashMap<>();
        jsonResponse.put("code", 0);
        jsonResponse.put("message", "Cập nhật một sản phẩm thành công có id: " + id);
        jsonResponse.put("data", existingProduct);
        response.getWriter().println(gson.toJson(jsonResponse));
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("application/json");
        Gson gson = new Gson();
        String id = request.getParameter("id");
        if(id == null){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            LinkedHashMap<String, Object> jsonResponse = new LinkedHashMap<>();
            jsonResponse.put("code", 2);
            jsonResponse.put("message", "Thiếu tham số id");;
            response.getWriter().println(gson.toJson(jsonResponse));
            return;

        }
        Product existingProduct = getProductById(id);
        if(existingProduct== null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            LinkedHashMap<String, Object> jsonResponse = new LinkedHashMap<>();
            jsonResponse.put("code", 2);
            jsonResponse.put("message", "Sản phầm không tồn tại");;
            response.getWriter().println(gson.toJson(jsonResponse));
            return;

        }
        products.remove(existingProduct);
        LinkedHashMap<String, Object> jsonResponse = new LinkedHashMap<>();
        jsonResponse.put("code", 0);
        jsonResponse.put("message", "xóa một sản phẩm thành công có id: " + id);
        jsonResponse.put("data", existingProduct);
        response.getWriter().println(gson.toJson(jsonResponse));


    }



    private Product getProductById(String id) {
        for(Product product : products){
            if(product.getId().equals(id)){
                return product ;
            }
        }
        return null;
    }
}
