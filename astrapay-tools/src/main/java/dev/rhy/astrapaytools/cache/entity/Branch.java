package dev.rhy.astrapaytools.cache.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter @Setter
public class Branch {

    @Id
    @Column(name = "id")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "address")
    private String address;

    @ManyToOne @JsonIgnore
    @JoinColumn(name = "merchant_id", referencedColumnName = "id")
    private Merchant merchant;
}
