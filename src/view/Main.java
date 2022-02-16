package view;

import controller.ContactManager;
import model.Contact;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = -1;
        ContactManager contactManager = new ContactManager();
        do {
            menuContact();
            System.out.println("Nhập lựa chọn của bạn");
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    int size = contactManager.size();
                    if (size == 0) {
                        System.out.println("Danh sách rỗng");
                    } else {
                        System.out.println("---Danh sách của danh bạ---");
                        contactManager.displayAllContact();
                    }
                    break;
                }
                case 2: {
                    System.out.println("--Thêm thông tin danh bạ--");
                    sc.nextLine();
                    Contact contact = getContac();
                    contactManager.addNewContact(contact);
                    break;
                }
                case 3: {
                    System.out.println("--Chỉnh sửa thông tin danh bạ--");
                    System.out.println("Nhập vị trí muốn sửa");
                    int index = sc.nextInt();
                    sc.nextLine();
                    if (index < 0 || index >= contactManager.size()) {
                        System.out.println("Vị trí chỉnh sửa không hợp lệ");
                    } else {
                        Contact contact = getContac();
                        contactManager.updateContact(index, contact);
                    }

                    break;
                }
                case 4: {
                    System.out.println("-- Xoá thông tin danh bạ--");
                    System.out.println("Nhập vị trí muốn xoá");
                    int index = sc.nextInt();
                    sc.nextLine();
                    if (index < 0 || index >= contactManager.size()) {
                        System.out.println("Vị trí xoá không hợp lệ");
                    } else {
                        contactManager.remoContact(index);
                    }
                    break;
                }
                case 5: {
                    System.out.println("--Tìm kiếm danh bạ theo tên--");
                    System.out.println("Nhập tên");
                    String name = sc.nextLine();
                    int result = contactManager.findContactByName(name);
                    if (result == Integer.parseInt(null)) {
                        System.out.println("Không tìm thấy");
                    } else {
                        System.out.println("Kết quả tìm kiếm là:");
                        System.out.println(result);
                    }
                    break;


                }

            }
        } while (choice != 8);


    }

    private static Contact getContac() {
        System.out.println("Nhập số điện thoại cần thêm");
        String phoneNumber = sc.nextLine();
        System.out.println("Nhập nhóm ");
        String group = sc.nextLine();
        System.out.println("Nhập họ và tên");
        String name = sc.nextLine();
        System.out.println("Nhập giới tính");
        String gender = sc.nextLine();
        System.out.println("Nhập địa chỉ");
        String address = sc.nextLine();
        System.out.println("Nhập ngày sinh");
        String dateOfBirth = sc.nextLine();
        System.out.println("Nhập email");
        String email = sc.nextLine();
        return new Contact(phoneNumber, group, name, gender, address, dateOfBirth, email);


    }

    private static void menuContact() {
        System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ----");
        System.out.println("Chọn chức năng theo số (để tiếp tục)");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhập");
        System.out.println("4. Xoá");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("8. Thoát");
        System.out.println("Chọn chức năng: ");
    }
}
