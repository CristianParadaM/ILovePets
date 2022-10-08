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

        products.add(new Product(idProductSerial++, "resource/chunky.jpg", "Purina Chunky A", 
    "Ingredientes:\n\nArroz, salmón, cordero, harina de salmón, salvado de trigo, aceite de pollo, hidrolizado de hígado de pollo, semilla de lino, cloruro de sodio, carbonato de calcio, fosfato dicálcico, cloruro de potasio, manano -oligosacáridos de la (no-GM) saccharomyces cerevisiae,  cloruro de colina, hierro quelado, sulfato ferroso, hidroxicloruro de zinc, zinc quelado, beta-glucanos, selenio quelado, cobre básico cloruro, cobre quelado, yodato de calcio, hidroxicloruro de manganeso, manganeso quelado, selenito de sodio, vitamina E tocoferol acetato, vitamina B3 niacinamida, vitamina B5, vitamina A retinol, vitamina H biotina, vitamina B2 riboflavina, vitamina K3 menadiona, vitamina B12 cianocobalamina, vitamina B1 tiamina, vitamina B6 piridoxina, vitamina D3 colecalciferol, vitamina B9 ácido fólico, sales de ácido propiónico, tocoferoles, aceite de romero, ácido cítrico."
                , 'D',
                "1.5Kg", 12500f, 0, 20,
                new Mark(idMarkSerial++, "Chunky")));


        products.add(new Product(idProductSerial++, "resource/cardimg.png", "Purina Felix Bebes", 
        "Ingredientes:\n\nArroz, salmón, cordero, harina de salmón, salvado de trigo, aceite de pollo, hidrolizado de hígado de pollo, semilla de lino, cloruro de sodio, carbonato de calcio, fosfato dicálcico, cloruro de potasio, manano -oligosacáridos de la (no-GM) saccharomyces cerevisiae,  cloruro de colina, hierro quelado, sulfato ferroso, hidroxicloruro de zinc, zinc quelado, beta-glucanos, selenio quelado, cobre básico cloruro, cobre quelado, yodato de calcio, hidroxicloruro de manganeso, manganeso quelado, selenito de sodio, vitamina E tocoferol acetato, vitamina B3 niacinamida, vitamina B5, vitamina A retinol, vitamina H biotina, vitamina B2 riboflavina, vitamina K3 menadiona, vitamina B12 cianocobalamina, vitamina B1 tiamina, vitamina B6 piridoxina, vitamina D3 colecalciferol, vitamina B9 ácido fólico, sales de ácido propiónico, tocoferoles, aceite de romero, ácido cítrico."
                , 'C',
                "1.5Kg", 10500f, 0, 20,
                new Mark(idMarkSerial++, "Felix")));

        products.add(new Product(idProductSerial++, "/resource/vivir.jpg", "Alimento aves", 
        "Ingredientes:\n\nArroz, salmón, cordero, harina de salmón, salvado de trigo, aceite de pollo, hidrolizado de hígado de pollo, semilla de lino, cloruro de sodio, carbonato de calcio, fosfato dicálcico, cloruro de potasio, manano -oligosacáridos de la (no-GM) saccharomyces cerevisiae,  cloruro de colina, hierro quelado, sulfato ferroso, hidroxicloruro de zinc, zinc quelado, beta-glucanos, selenio quelado, cobre básico cloruro, cobre quelado, yodato de calcio, hidroxicloruro de manganeso, manganeso quelado, selenito de sodio, vitamina E tocoferol acetato, vitamina B3 niacinamida, vitamina B5, vitamina A retinol, vitamina H biotina, vitamina B2 riboflavina, vitamina K3 menadiona, vitamina B12 cianocobalamina, vitamina B1 tiamina, vitamina B6 piridoxina, vitamina D3 colecalciferol, vitamina B9 ácido fólico, sales de ácido propiónico, tocoferoles, aceite de romero, ácido cítrico."
        , 'B', "1.5Kg",
                12500f, 15500f, 20, new Mark(10003, "Vivir")));

        products.add(new Product(idProductSerial++, "resource/incross.jpg", "Alimento Peces", 
        "Ingredientes:\n\nArroz, salmón, cordero, harina de salmón, salvado de trigo, aceite de pollo, hidrolizado de hígado de pollo, semilla de lino, cloruro de sodio, carbonato de calcio, fosfato dicálcico, cloruro de potasio, manano -oligosacáridos de la (no-GM) saccharomyces cerevisiae,  cloruro de colina, hierro quelado, sulfato ferroso, hidroxicloruro de zinc, zinc quelado, beta-glucanos, selenio quelado, cobre básico cloruro, cobre quelado, yodato de calcio, hidroxicloruro de manganeso, manganeso quelado, selenito de sodio, vitamina E tocoferol acetato, vitamina B3 niacinamida, vitamina B5, vitamina A retinol, vitamina H biotina, vitamina B2 riboflavina, vitamina K3 menadiona, vitamina B12 cianocobalamina, vitamina B1 tiamina, vitamina B6 piridoxina, vitamina D3 colecalciferol, vitamina B9 ácido fólico, sales de ácido propiónico, tocoferoles, aceite de romero, ácido cítrico."
        , 'F',
                "1.5Kg", 12500f, 0, 20,
                new Mark(idMarkSerial++, "Incross")));

        products.add(new Product(idProductSerial++, "resource/collar.jpg", "Collar Perros", 
        "Consiente a tu mascota con collares cómodos y prácticos. \n¡Visita nuestra tienda online! \n¡Nueva colección inspirada en las regiones de Colombia.! \n¡Con la sabrosura del Caribe! Pelota antisarro. \n\nPlaca para perro gratis. \nDiseños auténticos. \nExclusividad"
        , 'D', "1.5Kg",
                12500f, 0, 20,
                new Mark(idMarkSerial++, "Colla")));

        products.add(new Product(idProductSerial++, "resource/camagatos.jpg", "Camas gatos", "Ofertas en Camas gatos Y Una Gran Variedad De Productos y Marcas! Ingresa Hoy.\nLo Que Buscas En Camas Gatos lo Encuentras Aquí. \nIngresa Y Descubre Los Descuentos!", 'C',
                "1.5Kg", 12500f, 0, 20,
                new Mark(idMarkSerial++, "Karulla")));

        products.add(new Product(idProductSerial++, "resource/tasas.jpg", "Tazas de Comida", "Decidir cuánta alimentación del perro es adecuada, con qué frecuencia y qué tipo de alimento, son decisiones de gran importancia.", 'D',
                "1.5Kg", 12500f, 0, 20,
                new Mark(idMarkSerial++, "Doggies")));

        products.add(new Product(idProductSerial++, "resource/hueso.jpg", "Juguete Hueso", "Lo Que Buscas En Juguetes Para Perros lo Encuentras Aquí. Ingresa Y Descubre Los Descuentos! Devoluciones Gratis. Envío gratis desde $70000. Tiendas Oficiales. Compra Protegida. Hasta 12 cuotas s/interés.\nMarcas: Provipets, Puppis, Kanú.", 'D', "1.5Kg",
                12500f, 0, 20,
                new Mark(idMarkSerial++, "Petys")));

        products.add(new Product(idProductSerial++, "resource/peine.jpg", "Peine Perro", "Lo Que Buscas En Juguetes Para Perros lo Encuentras Aquí. Ingresa Y Descubre Los Descuentos! Devoluciones Gratis. Envío gratis desde $70000. Tiendas Oficiales. Compra Protegida. Hasta 12 cuotas s/interés.\nMarcas: Provipets, Puppis, Kanú.", 'D', "1.5Kg",
                12500f, 0, 20,
                new Mark(idMarkSerial++, "Exito")));

        products.add(new Product(idProductSerial++, "resource/pelota.jpg", "Pelota Perro", "Lo Que Buscas En Juguetes Para Perros lo Encuentras Aquí. Ingresa Y Descubre Los Descuentos! Devoluciones Gratis. Envío gratis desde $70000. Tiendas Oficiales. Compra Protegida. Hasta 12 cuotas s/interés.\nMarcas: Provipets, Puppis, Kanú.", 'D', "1.5Kg",
                12500f, 0, 20,
                new Mark(idMarkSerial++, "Exito")));

        products.add(new Product(idProductSerial++, "resource/pañales.jpg", "Pañales higienicos", "Con los Tapetes Absorbentes Petys, tu mascota puede hacer sus necesidades en casa, mientras mantienes el piso de tu hogar completamente limpio", 'D',
                "1.5Kg", 12500f, 0, 20,
                new Mark(idMarkSerial++, "Petys")));

        products.add(new Product(idProductSerial++, "resource/arenera.jpg", "Arenera", "Arena y Areneras para Gato con ofertas y descuento compra online en Linio Colombia. Encuentra la mayor variedad de Arena y Areneras para Gato en un sólo lugar", 'C', "1.5Kg",
                12500f, 0, 20,
                new Mark(idMarkSerial++, "Jumbo")));

        //----
        products.add(new Product(idProductSerial++, "resource/acuario.png", "Acuario", 
        "Moderno acuario para tus peces, donde podran nadar libremente en un moderno ambiente acuatico"
        , 'F', "20Kg",
                1500000f, 0, 2,
                new Mark(idMarkSerial++, "Acuarium")));

        products.add(new Product(idProductSerial++, "resource/ancla.png", "Accesorio ancla", 
        "Decora tu acuario con este increible accesorio, dale vida al mundo acuatico de tus peces!!"
        , 'F', "1Kg",
                20000f, 25000, 6,
                new Mark(idMarkSerial++, "FisheShop")));

        products.add(new Product(idProductSerial++, "resource/bebedero.png", "Bebedero aves", 
        "Perfecto e ideal bebedero para tus aves, donde podras alimentarlos y darles de beber facilmente, compralo ya!"
        , 'B', "2Kg",
                30000f, 0f, 20,
                new Mark(idMarkSerial++, "Vivir")));

        products.add(new Product(idProductSerial++, "resource/columpio.png", "Columpio Aves", 
        "Dale motivos a tus aves para que no se aburran en la jaula, dales un columpio donde puedan divertirse!"
        , 'B', "0.5Kg",
                10000f, 12000f, 2,
                new Mark(idMarkSerial++, "BirdsAll")));

        products.add(new Product(idProductSerial++, "resource/comedero.png", "Comedero Aves", 
        "Un lugar para darles la comida a tus aves, simple y sencillo pero practico, compralo ya! "
        , 'B', "1Kg",
                2000f, 5000f, 2,
                new Mark(idMarkSerial++, "ILoveBirds")));

        products.add(new Product(idProductSerial++, "resource/correagato.png", "Correas Gatos", 
        "Consiente a tu mascota con collares cómodos y prácticos. ¡Visita nuestra tienda online! ¡Nueva colección inspirada en las regiones de Colombia.! ¡Con la sabrosura del Caribe! Pelota antisarro. Placa para gatos gratis. Diseños auténticos. Exclusividad"
        , 'C', "0.5Kg",
                10000f, 12000f, 22,
                new Mark(idMarkSerial++, "ILoveCats")));

        products.add(new Product(idProductSerial++, "resource/filtrado.png", "Filtro Acuario", 
        "Novedoso filtro para la pecera o acuario que no puede faltar en los accesorios para tus mascotas submarinas!"
        , 'F', "1Kg",
                35000f, 40000f, 2,
                new Mark(idMarkSerial++, "Acuarium")));

        products.add(new Product(idProductSerial++, "resource/gimnasiogatos.png", "Gimnasio Gatos", 
        "Perfecto gimnasio para tus gatos, donde podran divertirse de la mejor manera, nunca se aburriran de saltar y escalar en este novedoso sistema para tus mascotas"
        , 'C', "3Kg",
                100000f, 150000, 2,
                new Mark(idMarkSerial++, "Exito")));

        products.add(new Product(idProductSerial++, "resource/jaula.png", "Jaula aves", 
        "Ideal jaula para tus aves, amplias y comodas donde podras armar un hogar perfecto para tus aves voladoras"
        , 'B', "2Kg",
                30500f, 32000f, 2,
                new Mark(idMarkSerial++, "ILoveBirds")));

        products.add(new Product(idProductSerial++, "resource/lampara.png", "Lampara Sumergible", 
        "Ilumina tu pecera o acuario con esta novedosa lampara LED que posee multiples colores para darle una vida mas colorida a tus mascotas"
        , 'F', "1Kg",
                50000f, 60000f, 5,
                new Mark(idMarkSerial++, "ILoveFishes")));

        products.add(new Product(idProductSerial++, "resource/malla.png", "Malla Transparente", 
        "Manten seguros a tus gatos con estas mallas transparentes ideal poner en balcones y ventanas, no esperes mas llevalo ya!"
        , 'C', "1.5Kg",
                15000f, 0, 2,
                new Mark(idMarkSerial++, "Cats Colombia")));



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
