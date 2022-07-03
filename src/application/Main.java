    package application;

    import entities.Cliente;
    import entities.ItemPedido;
    import entities.Order;
    import entities.Produto;
    import entities.enums.StatusPedido;

    import java.text.ParseException;
    import java.text.SimpleDateFormat;
    import java.util.Date;
    import java.util.Locale;
    import java.util.Scanner;

    public class Main {

        public static void main(String[] args) throws ParseException {
            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            System.out.println("Informe os dados do cliente: ");
            System.out.print("Nome: ");
            String nomeCliente = sc.nextLine();
            System.out.print("E-mail: ");
            String emailCliente = sc.nextLine();
            System.out.print("Data de nascimento (DD/MM/YYYY) : ");
            Date dataNascCliente = sdf.parse(sc.next());
            Cliente cliente = new Cliente(nomeCliente,emailCliente,dataNascCliente);

            System.out.println();
            System.out.println("Insira os dados do pedido: ");
            System.out.print("Status : ");
            StatusPedido status = StatusPedido.valueOf(sc.next());

            Order order = new Order(new Date(),status,cliente);

            System.out.print("Quantos itens para este pedido ? : ");
            int n = sc.nextInt();

            for (int i = 1 ; i <= n ; i ++){
                System.out.println("Informe os dados do # " + i + " item");
                System.out.print("Nome do produto :");
                sc.nextLine();
                String nomeProd = sc.nextLine();
                System.out.print("Infome o preco do produto: ");
                double precoProd = sc.nextDouble();

                Produto produto = new Produto(nomeProd,precoProd);

                System.out.print("Quantidade do produto: ");
                int qtdProd = sc.nextInt();

                ItemPedido itemPedidos = new ItemPedido(qtdProd,precoProd,produto);

                order.addItem(itemPedidos);
            }

            System.out.println();
            System.out.println("Sumario do Pedido: ");
            System.out.println(order);

            sc.close();
        }
    }
