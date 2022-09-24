package co.edu.utp.main.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shop {

    private ArrayList<Product> products;
    private ArrayList<Sale> sales;
    private ArrayList<Client> clients;
    private static Shop shop = null;

    public static final Shop getInstance() {
        if (shop == null) {
            shop = new Shop();
        }
        return shop;
    }

    private Shop() {
        products = new ArrayList<>();
        sales = new ArrayList<>();
        clients = new ArrayList<>();

        products.add(new Product(1, "resource/chunky.jpg", "Purina Chunky A", "Hola descripcion producto 1", 'D', "1.5Kg", 12500f, 0, 20,
        new Mark(10001, "Chunky")));

        products.add( new Product(2, "resource/cardimg.png", "Purina Felix Bebes", "Hola descripcion producto 2", 'C', "1.5Kg", 10500f, 0, 20,
        new Mark(10002, "Felix")));
        
        products.add(new Product(3, "/resource/vivir.jpg", "Alimento aves", "Hola descripcion producto 3", 'B', "1.5Kg",
        12500f, 15500f, 20, new Mark(10003, "Vivir")));

        products.add(new Product(4, "resource/incross.jpg", "Alimento Peces", "Hola descripcion producto 4", 'F', "1.5Kg", 12500f, 0, 20,
        new Mark(10004, "Incross")));

        products.add(new Product(5, "resource/collar.jpg", "Collar Perros", "Hola descripcion producto 4", 'D', "1.5Kg", 12500f, 0, 20,
        new Mark(10005, "Colla")));

        products.add( new Product(6, "resource/camagatos.jpg", "Camas gatos", "Hola descripcion producto 4", 'C', "1.5Kg", 12500f, 0, 20,
        new Mark(10006, "Karulla")));

        products.add( new Product(8, "resource/tasas.jpg", "Tazas de Comida", "Hola descripcion producto 4", 'D', "1.5Kg", 12500f, 0, 20,
        new Mark(10007, "Doggies")));

        products.add(new Product(9, "resource/hueso.jpg", "Juguete Hueso", "Hola descripcion producto 4", 'D', "1.5Kg", 12500f, 0, 20,
        new Mark(10008, "Petys")));

        products.add( new Product(10, "resource/peine.jpg", "Peine Perro", "Hola descripcion producto 4", 'D', "1.5Kg", 12500f, 0, 20,
        new Mark(10009, "Exito")));

        products.add( new Product(11, "resource/pelota.jpg", "Pelota Perro", "Hola descripcion producto 4", 'D', "1.5Kg", 12500f, 0, 20,
        new Mark(10009, "Exito")));

        products.add( new Product(12, "resource/pañales.jpg", "Pañales higienicos", "Hola descripcion producto 4", 'D', "1.5Kg", 12500f, 0, 20,
        new Mark(10008, "Petys")));

        products.add(new Product(13, "resource/arenera.jpg", "Arenera", "Hola descripcion producto 4", 'C', "1.5Kg", 12500f, 0, 20,
        new Mark(10010, "Jumbo")));

        products.add(new Product(14, "/resource/vivir.jpg", "Alimento aves", "Hola descripcion producto 3", 'B', "1.5Kg",
        12500f, 0, 20, new Mark(10003, "Vivir")));
                
        products.add(new Product(15, "/resource/vivir.jpg", "Alimento aves", "Hola descripcion producto 3", 'B', "1.5Kg",
        12500f, 0, 20, new Mark(10003, "Vivir")));
                
        products.add(new Product(16, "resource/incross.jpg", "Alimento Peces", "Hola descripcion producto 4", 'F', "1.5Kg", 12500f, 0, 20,
        new Mark(10004, "Incross")));

        products.add(new Product(17, "resource/incross.jpg", "Alimento Peces", "Hola descripcion producto 4", 'F', "1.5Kg", 12500f, 0, 20,
        new Mark(10004, "Incross")));

        clients.add(new Client(1, "Cristian", "Parada", LocalDate.of(2001, 9, 21), "Maria Fernanda Apto 627"));

        sales.add(new Sale(1, Arrays.asList(1, 2, 3, 4, 11, 11, 11), LocalDateTime.now(), EnumTypeToPay.CASH, 1));
        sales.add( new Sale(2, Arrays.asList(2, 2, 2, 3, 10, 10, 11), LocalDateTime.now(), EnumTypeToPay.CASH, 1));
        sales.add(new Sale(3, Arrays.asList(3, 3, 3, 5), LocalDateTime.now(), EnumTypeToPay.CASH, 1));

        products.sort((o1, o2) -> {
            return o1.getName().compareTo(o2.getName());
        });
    }

    public List<Product> searchProducts(String text) {
        text = text.toLowerCase();
        ArrayList<Product> productsSearch = new ArrayList<>();
        for (Product product : this.products) {
            if (product.getName().toLowerCase().contains(text)
                    || product.getMark().getName().toLowerCase().contains(text)) {
                productsSearch.add(product);
            }
        }
        return productsSearch;
    }

    public List<Product> getFeatureProducts(int option) {
        ArrayList<Object[]> products = new ArrayList<>();
        for (Sale sale : sales) {
            for (Integer idProduct : sale.getProducts()) {
                Product product = getProductById(idProduct);
                int index = isRepeated(product, products);
                if (index == -1) {
                    products.add(new Object[] { product, 1 });
                } else {
                    products.get(index)[1] = ((Integer) products.get(index)[1]) + 1;
                }
            }
        }
        quickSort(products, 0, products.size() - 1);
        ArrayList<Product> p = new ArrayList<>();
        for (int i = 0; i < (option == 0 ? 5 : products.size()); i++) {
            if (products.size() > i) {
                p.add((Product) products.get(i)[0]);
            }
        }
        return p;
    }

    public List<Product> getPetProducts(int option, char type) {
        ArrayList<Object[]> productsDogs = new ArrayList<>();
        for (Product product : this.products) {
            if (product.getTypePet() == type) {
                int index = isRepeated(product, productsDogs);
                if (index == -1) {
                    productsDogs.add(new Object[] { product, 1 });
                } else {
                    productsDogs.get(index)[1] = ((Integer) productsDogs.get(index)[1]) + 1;
                }
            }
        }
        quickSort(productsDogs, 0, productsDogs.size() - 1);
        ArrayList<Product> p = new ArrayList<>();
        for (int i = 0; i < (option == 0 ? 5 : productsDogs.size()); i++) {
            if (productsDogs.size() > i) {
                p.add((Product) productsDogs.get(i)[0]);
            }
        }
        return p;
    }

    public int isRepeated(Product product, ArrayList<Object[]> list) {
        for (int i = 0; i < list.size(); i++) {
            if (product == (Product) list.get(i)[0]) {
                return i;
            }
        }
        return -1;
    }

    public void quickSort(ArrayList<Object[]> list, int izq, int der) {
        int i = izq, j = der;
        Integer pivote = (Integer) list.get((i + j) / 2)[1];
        do {
            for (; (Integer) list.get(i)[1] > pivote; i++)
                ;
            for (; (Integer) list.get(j)[1] < pivote; j--)
                ;
            if (i <= j) {
                Object[] aux = list.get(i);
                list.set(i, list.get(j));
                list.set(j, aux);
                i++;
                j--;
            }
        } while (i <= j);
        if (izq < j) {
            quickSort(list, izq, j);
        }
        if (i < der) {
            quickSort(list, i, der);
        }
    }

    public Product getProductById(int id) {
        for (Product product : products) {
            if (id == product.getIdProduct()) {
                return product;
            }
        }
        return null;
    }

    public void addProduct(Product product){
        System.out.println(product);
        this.products.add(product);
    }

}
