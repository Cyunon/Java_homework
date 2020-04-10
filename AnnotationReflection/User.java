package AnnotationReflection;

@Table("user")
public class User{
    @Column("id")
    private int id;

    @Column("username")
    private String username;
    
    @Column("age")
    private int age;

    @Column("email")
    private String email;

    @Column("telephone")
    private String telephone;

	public void setId(int id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	public void setUsername(String name) {
		// TODO Auto-generated method stub
		this.username = name;
	}

	public void setTelephone(String tel) {
		// TODO Auto-generated method stub
		this.telephone = tel;
	}

	public void setEmail(String email) {
		// TODO Auto-generated method stub
		this.email = email;
	}

	public void setAge(int age) {
		// TODO Auto-generated method stub
		this.age = age;
	}
}
