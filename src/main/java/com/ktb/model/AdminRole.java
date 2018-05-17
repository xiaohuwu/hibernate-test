package com.ktb.model;

import javax.persistence.*;

@Entity
@Table(name="t_admin_role")
public class AdminRole
{
    private int id;
    private String name;
    private Admin admin;
    private Role role;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    @ManyToOne
    @JoinColumn(name="admin_id")
    public Admin getAdmin()
    {
        return admin;
    }
    public void setAdmin(Admin admin)
    {
        this.admin = admin;
    }
    @ManyToOne
    @JoinColumn(name="role_id")
    public Role getRole()
    {
        return role;
    }
    public void setRole(Role role)
    {
        this.role = role;
    }
}
