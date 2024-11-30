package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TicketService {

    public static void buyTicket(Connection conn, int showtimeId, int seatId, String cardNumber) {
        String insertTicketQuery = "INSERT INTO Ticket (showtime_id, seat_id, card_number) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertTicketQuery)) {
            pstmt.setInt(1, showtimeId);
            pstmt.setInt(2, seatId);
            pstmt.setString(3, cardNumber);
            pstmt.executeUpdate();
            System.out.println("Ticket purchased successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred while purchasing the ticket.");
        }
    }
}
