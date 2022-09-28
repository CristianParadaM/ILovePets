package co.edu.utp.main.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Shop {
    private ArrayList<Product> products;
    private ArrayList<Sale> sales;
    private ArrayList<Client> clients;
    private static Shop shop = null;
    private int idProductSerial;
    private int idSaleSerial;
    private int idMarkSerial;

    public static final String USER_ADMIN = "crispo";
    public static final String PASS_ADMIN = "2001";

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

        this.idProductSerial = 20221001;
        this.idSaleSerial = 20221;
        this.idMarkSerial = 1;

        products.add(new Product(idProductSerial++, "resource/chunky.jpg", "Purina Chunky A", "Hola descripcion producto 1", 'D',
                "1.5Kg", 12500f, 0, 20,
                new Mark(idMarkSerial++, "Chunky")));


        products.add(new Product(idProductSerial++, "resource/cardimg.png", "Purina Felix Bebes", "Hola descripcion producto 2", 'C',
                "1.5Kg", 10500f, 0, 20,
                new Mark(idMarkSerial++, "Felix")));

        products.add(new Product(idProductSerial++, "/resource/vivir.jpg", "Alimento aves", "Hola descripcion producto 3", 'B', "1.5Kg",
                12500f, 15500f, 20, new Mark(10003, "Vivir")));

        products.add(new Product(idProductSerial++, "resource/incross.jpg", "Alimento Peces", "Hola descripcion producto 4", 'F',
                "1.5Kg", 12500f, 0, 20,
                new Mark(idMarkSerial++, "Incross")));

        products.add(new Product(idProductSerial++, "resource/collar.jpg", "Collar Perros", "Hola descripcion producto 4", 'D', "1.5Kg",
                12500f, 0, 20,
                new Mark(idMarkSerial++, "Colla")));

        products.add(new Product(idProductSerial++, "resource/camagatos.jpg", "Camas gatos", "Hola descripcion producto 4", 'C',
                "1.5Kg", 12500f, 0, 20,
                new Mark(idMarkSerial++, "Karulla")));

        products.add(new Product(idProductSerial++, "resource/tasas.jpg", "Tazas de Comida", "Hola descripcion producto 4", 'D',
                "1.5Kg", 12500f, 0, 20,
                new Mark(idMarkSerial++, "Doggies")));

        products.add(new Product(idProductSerial++, "resource/hueso.jpg", "Juguete Hueso", "Hola descripcion producto 4", 'D', "1.5Kg",
                12500f, 0, 20,
                new Mark(idMarkSerial++, "Petys")));

        products.add(new Product(idProductSerial++, "resource/peine.jpg", "Peine Perro", "Hola descripcion producto 4", 'D', "1.5Kg",
                12500f, 0, 20,
                new Mark(idMarkSerial++, "Exito")));

        products.add(new Product(idProductSerial++, "resource/pelota.jpg", "Pelota Perro", "Hola descripcion producto 4", 'D', "1.5Kg",
                12500f, 0, 20,
                new Mark(idMarkSerial++, "Exito")));

        products.add(new Product(idProductSerial++, "resource/pañales.jpg", "Pañales higienicos", "Hola descripcion producto 4", 'D',
                "1.5Kg", 12500f, 0, 20,
                new Mark(idMarkSerial++, "Petys")));

        products.add(new Product(idProductSerial++, "resource/arenera.jpg", "Arenera", "Hola descripcion producto 4", 'C', "1.5Kg",
                12500f, 0, 20,
                new Mark(idMarkSerial++, "Jumbo")));

        products.add(
                new Product(idProductSerial++, "/resource/vivir.jpg", "Alimento aves", "Hola descripcion producto 3", 'B', "1.5Kg",
                        12500f, 0, 20, new Mark(idMarkSerial++, "Vivir")));

        products.add(
                new Product(idProductSerial++, "/resource/vivir.jpg", "Alimento aves", "Hola descripcion producto 3", 'B', "1.5Kg",
                        12500f, 0, 20, new Mark(idMarkSerial++, "Vivir")));

        products.add(new Product(idProductSerial++, "resource/incross.jpg", "Alimento Peces", "Hola descripcion producto 4", 'F',
                "1.5Kg", 12500f, 0, 20,
                new Mark(idMarkSerial++, "Incross")));

        products.add(new Product(idProductSerial++, "resource/incross.jpg", "Alimento Peces", "Hola descripcion producto 4", 'F',
                "1.5Kg", 12500f, 0, 20,
                new Mark(idMarkSerial++, "Incross")));

        clients.add(new Client(1002365941, "Cristian", "Parada", LocalDate.of(2001, 9, 21), "Maria Fernanda Apto 627"));

        ArrayList<Integer> p = new ArrayList<>();
        p.add(20221001);
        p.add(20221002);
        p.add(20221003);
        p.add(20221004);
        p.add(20221011);
        p.add(20221011);
        p.add(20221011);

        ArrayList<Integer> p1 = new ArrayList<>();
        p1.add(20221002);
        p1.add(20221002);
        p1.add(20221002);
        p1.add(20221003);
        p1.add(20221010);
        p1.add(20221011);
        p1.add(20221011);

        ArrayList<Integer> p2 = new ArrayList<>();
        p1.add(20221003);
        p1.add(20221003);
        p1.add(20221003);
        p1.add(20221005);

        sales.add(new Sale(idSaleSerial++, p, LocalDateTime.now(), EnumTypeToPay.CASH, 200000f,10000f,210000f, 1));
        sales.add(new Sale(idSaleSerial++, p1, LocalDateTime.now(), EnumTypeToPay.CASH,200000f,10000f,210000f, 1));
        sales.add(new Sale(idSaleSerial++, p2, LocalDateTime.now(), EnumTypeToPay.CASH,100000f,10000f,110000f, 1));

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

    public boolean modify(int id, Object[] changes) {
        boolean b = false;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getIdProduct() == id) {
                for (int j = 0; j < changes.length; j++) {
                    if (changes[j] != null) {
                        b = true;
                        switch (j) {
                            case 0:
                                products.get(i).setName((String) changes[j]);
                                break;
                            case 1:
                                products.get(i).setUrlimg((String) changes[j]);
                                break;
                            case 2:
                                products.get(i).setDescription((String) changes[j]);
                                break;
                            case 3:
                                products.get(i).setTypePet((char) changes[j]);
                                break;
                            case 4:
                                products.get(i).getMark().setName((String) changes[j]);
                                break;
                            case 5:
                                products.get(i).setPrice((float) changes[j]);
                                break;
                            case 6:
                                products.get(i).setQuantyStock((int) changes[j]);
                                break;
                            case 7:
                                products.get(i).setPriceDes((float) changes[j]);
                                break;
                        }
                    }
                }
                break;
            }
        }
        return b;
    }

    public List<Product> getFeatureProducts(int option) {
        ArrayList<Object[]> products = new ArrayList<>();
        for (Sale sale : sales) {
            for (Integer idProduct : sale.getProducts()) {
                Product product = getProductById(idProduct);
                if (product!=null) {
                    int index = isRepeated(product, products);
                    if (index == -1) {
                        products.add(new Object[] { product, 1 });
                    } else {
                        products.get(index)[1] = ((Integer) products.get(index)[1]) + 1;
                    }
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

    public boolean addProduct(Product productA) {
        boolean status = true;
        for (Product product : products) {
            if (product.getIdProduct() == productA.getIdProduct()) {
                status = false;
            }
        }
        if (status) {
            this.products.add(productA);
        }
        return status;
    }

    public boolean remove(int idFocus) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getIdProduct() == idFocus) {
                products.remove(i);
                return true;
            }
        }
        return false;
    }

    public Client searchClientById(int id){
        for (Client client : clients) {
            if (client.getId() == id) {
                return client;
            }
        }
        return null;
    }

    public boolean addSale(Sale sale){
        return sales.add(sale);
    }

    public int getIdProductSerial() {
        return idProductSerial++;
    }

    public int getIdMarkSerial() {
        return idMarkSerial++;
    }

    public int getIdSaleSerial() {
        return idSaleSerial++;
    }

}
