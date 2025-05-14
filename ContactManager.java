package ContactManagementSystem;

import java.util.ArrayList;

public class ContactManager {

	private ArrayList<Contact> contact= new ArrayList<>();
	private int nextId=1;

	public void AddContact(String name,String num,String email) {
		Contact c= new Contact(nextId++,name,num,email);
		contact.add(c);

		System.out.println("Contact added successfully:" +c);
	}

	public void SearchByName(String name) {
		@SuppressWarnings("unused")
		boolean isThere= false;
		for(Contact c: contact) {
			if(c.getName().toLowerCase().contains(name.toUpperCase())) {
				System.out.println(c);
				isThere= true;
			}
		}
		
		if(!isThere) {
			System.out.println("No contact found for:" +name);
		}
	}
	
	public void SearchByNumber(String num) {
		@SuppressWarnings("unused")
		boolean isThere= false;
		for(Contact c: contact) {
			if(c.getNum().contains(num)) {
				System.out.println(c);
				isThere= true;
			}
		}
		
		if(!isThere) {
			System.out.println("No contact found for:" +num);
		}
	}
	
	public void deleteById(int id) {
		boolean deleted= contact.removeIf(c->c.getId()==id);
		if(deleted) {
			System.out.println("Contact deleted of id:"+id);
		}
		else {
			System.out.println("Contact not found of id:"+ id);
		}
	}
	
	public void updateContact(int id,String newName,String newNum,String newEmail) {
		for(Contact c: contact) {
			if(c.getId()==id) {
				c.setName(newName);
				c.setNum(newNum);
				c.setEmail(newEmail);
				System.out.println("Contact Updated Successfully:"+ c);
				return;
			}
		}
		 System.out.println("Contact not found with ID: " + id);
    }

    public void DisplayAllContacts() {
        if (contact.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            for (Contact c : contact) {
                System.out.println(c);
            }
        }
    }
		
	}
	
	
	
	

