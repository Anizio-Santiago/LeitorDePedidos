    package entities;

    import entities.enums.StatusPedido;

    import java.text.SimpleDateFormat;
    import java.util.ArrayList;
    import java.util.Date;
    import java.util.List;

    public class Order {

        private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        private Date momento;
        private StatusPedido status;

        private Cliente cliente;
        private List<ItemPedido> itemPedidos =  new ArrayList<>();

        public Order(){

        }

        public Order(Date momento, StatusPedido status, Cliente cliente) {
            this.momento = momento;
            this.status = status;
            this.cliente = cliente;
        }

        public Date getMomento() {
            return momento;
        }

        public void setMomento(Date momento) {
            this.momento = momento;
        }

        public StatusPedido getStatus() {
            return status;
        }

        public void setStatus(StatusPedido status) {
            this.status = status;
        }

        public Cliente getCliente() {
            return cliente;
        }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }

        public List<ItemPedido> getItemPedidos() {
            return itemPedidos;
        }

        public void addItem(ItemPedido itempedido){ // Metodo para adicionar um pedido na lista.
            itemPedidos.add(itempedido);
        }

        public void removerItem(ItemPedido itemPedido){ // Metodo para remover um pedido na lista.
            itemPedidos.remove(itemPedido);
        }

        public Double total (){
            double soma = 0.0;
            for(ItemPedido item : itemPedidos){
                soma += item.subTotal();
            }
            return soma;
        }
        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append("Momento do pedido: ");
            sb.append(sdf.format(momento) + "\n");
            sb.append("Status do pedido: ");
            sb.append(status + "\n");
            sb.append("Cliente : ");
            sb.append(cliente + "\n");
            sb.append("Itens de pedido: \n");
            for(ItemPedido item : itemPedidos){
                sb.append(item + "\n");
            }
            sb.append("Preco total : $");
            sb.append(String.format("%.2f",total()));
            return sb.toString();
        }

    }
