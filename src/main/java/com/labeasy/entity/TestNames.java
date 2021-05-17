package com.labeasy.entity;


import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "test_names")
public class TestNames extends BaseBean implements Serializable  {

	private static final long serialVersionUID = 6549598896213962887L;

	@Id
    @Column(name = "test_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  "testnameseq")
	@SequenceGenerator(name = "testnameseq", sequenceName = "test_id" , allocationSize = 1,initialValue =  1)
    private Long testId;
	@Column(name = "group_id")
	private Long groupId;
    @Column(name = "name", length = 250)
    private String name;
    @Column(name = "test_code", length = 20)
    private String testcode;
    @Column(name = "description", length = 250)
    private String description;
    @Column(name = "price")
	private Long price;
    @Column(name = "b2b_price")
	private Long b2bprice;
    @Column(name = "status" )
    private String status;
    @ManyToMany(mappedBy = "testNames")
	private Set<Appointment> appointments =null;

    

}
