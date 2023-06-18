package com.demo.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cart_master_tbl")
@ToString
public class Cart extends BaseAudit {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private Integer productRewards;

    @ManyToOne
    @JoinColumn(name = "login_id")
    private Employee loginId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productId;

    @Column(name = "product_status")
    private String productStatus;

    @Column(name = "order_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String orderId;

//    @PrePersist
//    public static UUID generateType1UUID() {
//        long most64SigBits = get64MostSignificantBitsForVersion1();
//        long least64SigBits = get64LeastSignificantBitsForVersion1();
//        return new UUID(most64SigBits, least64SigBits);
//    }
//
//    private static long get64MostSignificantBitsForVersion1() {
//        final long currentTimeMillis = System.currentTimeMillis();
//        final long time_low = (currentTimeMillis & 0x0000_0000_FFFF_FFFFL) << 32;
//        final long time_mid = ((currentTimeMillis >> 32) & 0xFFFF) << 16;
//        final long version = 1 << 12;
//        final long time_hi = ((currentTimeMillis >> 48) & 0x0FFF);
//        return time_low | time_mid | version | time_hi;
//    }
//
//    private static long get64LeastSignificantBitsForVersion1() {
//        Random random = new Random();
//        long random63BitLong = random.nextLong() & 0x3FFFFFFFFFFFFFFFL;
//        long variant3BitFlag = 0x8000000000000000L;
//        return random63BitLong | variant3BitFlag;
//    }
}

