import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/agraf";
    private static final String USER = "MariaDB"; // Ajuste conforme sua configuração
    private static final String PASSWORD = "123456"; // Ajuste conforme sua configuração

    public void salvarCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes (nome, endereco, telefone, email) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());

            stmt.executeUpdate();
            System.out.println("Cliente cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }
}
