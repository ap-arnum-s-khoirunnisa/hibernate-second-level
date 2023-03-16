package dev.rhy.astrapaytools.cache.entity;


import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.List;

@Entity
@Getter @Setter
@org.hibernate.annotations.Cache( usage = CacheConcurrencyStrategy.READ_WRITE, region = "testCache1")
public class Merchant {

    @Id
    @Column(name = "id")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;


    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "merchant", fetch = FetchType.LAZY)
    private List<Branch> listBranch;

}
