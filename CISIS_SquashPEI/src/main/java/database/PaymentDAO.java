package database;

import beans.Notification;
import beans.Payment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.ConnectionUtils;
import util.DbUtils;

/**
 *
 * @author BJ
 */
public class PaymentDAO {

    /**
     * This method will insert.
     *
     * @return
     * @author BJ
     * @since 20140615
     */
    public static void insertPayment(Payment payment) throws Exception {
        System.out.println("inserting payment");
        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;

        /*
         * Setup the sql to update or insert the row.
         */
        try {
            conn = ConnectionUtils.getConnection();

            sql = "INSERT INTO `member_payment`(`member_id`, "
                    + "`payment_amount`, `payment_detail`, "
                    + "`payment_season_code`, `created_date_time`, `created_user_id`, "
                    + "`updated_date_time`, `updated_user_id`) VALUES (?,?,?,?, sysdate(), ?, sysdate(), ?)";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, payment.getMemberId());
            ps.setDouble(2, Double.parseDouble(payment.getPaymentAmount()));
            ps.setString(3, payment.getPaymentDetail());
            ps.setInt(4, Integer.parseInt(payment.getPaymentSeasonCode()));
            ps.setString(5, payment.getUserId());
            ps.setString(6, payment.getUserId());
            ps.executeUpdate();

        } catch (Exception e) {
            String errorMessage = e.getMessage();
            System.err.println(errorMessage);
            throw e;
        } finally {
            DbUtils.close(ps, conn);
        }
    }

    /**
     * Delete the specified member education (set to inactive)
     * @param memberId
     * @param memberEducationSequence 
     */
    public static void deletePayment(int paymentId) throws Exception{
        
        System.out.println("deleting payment");
        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;

        /*
         * Setup the sql to update or insert the row.
         */
        try {
            conn = ConnectionUtils.getConnection();

            sql = "update notification set payment_status_code = 2, updated_date_time = sysdate() "
                + "where payment_id = ? ";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, paymentId);

            ps.executeUpdate();

        } catch (Exception e) {
            String errorMessage = e.getMessage();
            System.err.println(errorMessage);
            throw e;
        } finally {
            DbUtils.close(ps, conn);
        }
        

    }
        

    
    public static ArrayList<Payment> getPayments(int memberId) {
        ArrayList<Payment> payments = new ArrayList();
        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();

            sql = "SELECT * FROM member_payment WHERE member_id = ? and status_code = 1 order by created_date_time desc";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, memberId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Payment newPayment = new Payment();
                newPayment.setMemberId(memberId);
                newPayment.setPaymentAmount(String.valueOf(rs.getDouble("payment_amount")));
                newPayment.setPaymentDetail(rs.getString("payment_detail"));
                newPayment.setPaymentSeasonCode(String.valueOf(rs.getInt("payment_season_code")));
                newPayment.setUserId(rs.getString("updated_user_id"));
                payments.add(newPayment);
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        } finally {
            DbUtils.close(ps, conn);
        }
        System.out.println("DEBUGGING-Found "+payments.size()+" payments");
        return payments;
    }

}
