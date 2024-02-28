package com.sparta.springlv2.entity;

import com.sparta.springlv2.dto.RentRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "rent")
@NoArgsConstructor
public class Rent extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "bookId", nullable = false)
    private Long bookId;
    @Column(name = "userId", nullable = false)
    private Long userId;
    @Column(name = "returned")
    private boolean returned;

    public Rent(RentRequestDto rentRequestDto) {
        this.bookId = rentRequestDto.getBookId();
        this.userId = rentRequestDto.getUserId();
        this.returned = rentRequestDto.isReturned();
    }

    public void update(RentRequestDto rentRequestDto) {
        this.returned = rentRequestDto.isReturned();
    }
}
