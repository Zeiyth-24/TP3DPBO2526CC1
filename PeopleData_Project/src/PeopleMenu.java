import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PeopleMenu extends JFrame {
    private JPanel mainPanel;
    private JTextField idField;
    private JTextField namaField;
    private JTextField tahunLahirField;
    private JComboBox kategoriComboBox;
    private JComboBox genderComboBox;
    private JTable peopleTable;
    private JButton addUpdateButton;
    private JButton deleteButton;
    private JButton cancelButton;

    private final ArrayList listPerson;
    private int selectedIndex = -1;

    public PeopleMenu() {
        listPerson = new ArrayList<>();
        populateList();
        peopleTable.setModel(setTable());

        // Pilihan dropdown Kategori & Gender
        kategoriComboBox.setModel(new DefaultComboBoxModel<>(new String[]{
                "PNS", "Swasta", "Mahasiswa", "Direktur", "Lainnya"
        }));
        genderComboBox.setModel(new DefaultComboBoxModel<>(new String[]{
                "Pria", "Wanita"
        }));

        //deleteButton.setVisible(false);

        // Listener tombol Add/Update
        addUpdateButton.addActionListener(e -> {
            if (selectedIndex == -1) {
                insertData();
            } else {
                updateData();
            }
        });

        // Listener tombol Delete (DENGAN POP-UP KONFIRMASI)
        deleteButton.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                    null,
                    "Apakah Anda yakin ingin menghapus data ini?",
                    "Konfirmasi Hapus",
                    JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                deleteData();
            }
        });

        // Listener tombol Cancel
        cancelButton.addActionListener(e -> clearForm());

        // Listener klik baris tabel
        peopleTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                selectedIndex = peopleTable.getSelectedRow();

                idField.setText(peopleTable.getValueAt(selectedIndex, 1).toString());
                namaField.setText(peopleTable.getValueAt(selectedIndex, 2).toString());
                tahunLahirField.setText(peopleTable.getValueAt(selectedIndex, 3).toString());
                kategoriComboBox.setSelectedItem(peopleTable.getValueAt(selectedIndex, 4).toString());
                genderComboBox.setSelectedItem(peopleTable.getValueAt(selectedIndex, 5).toString());

                addUpdateButton.setText("Update");
                deleteButton.setVisible(true);
            }
        });
    }

    // 1. Data Awal (Dummy Data)
    private void populateList() {
        listPerson.add(new Person("101", "Ferry Irwandi", "1990", "Swasta", "Pria"));
        listPerson.add(new Person("102", "Saniyya", "2003", "Direktur", "Wanita"));
        listPerson.add(new Person("103", "Stephen", "2001", "Mahasiswa", "Pria"));
    }

    // 2. Set Tampilan Header & Data ke DefaultTableModel
    public DefaultTableModel setTable() {
        String[] column = {"No", "ID", "Nama", "Tahun Lahir", "Kategori", "Gender"};
        DefaultTableModel model = new DefaultTableModel(column, 0);

        for (int i = 0; i < listPerson.size(); i++) {
            Person p = (Person) listPerson.get(i);
            Object[] row = {
                    (i + 1),
                    p.getId(),
                    p.getNama(),
                    p.getTahunLahir(),
                    p.getKategori(),
                    p.getGender()
            };
            model.addRow(row);
        }

        return model;
    }

    // 3. Tambah Data Baru
    private void insertData() {
        String id = idField.getText().trim();
        String nama = namaField.getText().trim();
        String tahunLahir = tahunLahirField.getText().trim();
        String kategori = kategoriComboBox.getSelectedItem().toString();
        String gender = genderComboBox.getSelectedItem().toString();

        if (id.isEmpty() || nama.isEmpty() || tahunLahir.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Harap isi semua field input!");
            return;
        }

        Person newPerson = new Person(id, nama, tahunLahir, kategori, gender);
        listPerson.add(newPerson);

        peopleTable.setModel(setTable());
        clearForm();
        JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan!");
    }

    // 4. Update Data Terpilih
    private void updateData() {
        String id = idField.getText().trim();
        String nama = namaField.getText().trim();
        String tahunLahir = tahunLahirField.getText().trim();
        String kategori = kategoriComboBox.getSelectedItem().toString();
        String gender = genderComboBox.getSelectedItem().toString();

        if (id.isEmpty() || nama.isEmpty() || tahunLahir.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Harap isi semua field input!");
            return;
        }

        Person updatedPerson = new Person(id, nama, tahunLahir, kategori, gender);
        listPerson.set(selectedIndex, updatedPerson);

        peopleTable.setModel(setTable());
        clearForm();
        JOptionPane.showMessageDialog(this, "Data berhasil diubah!");
    }

    // 5. Hapus Data
    private void deleteData() {
        if (selectedIndex >= 0 && selectedIndex < listPerson.size()) {
            listPerson.remove(selectedIndex);
            peopleTable.setModel(setTable());
            clearForm();
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
        }
    }

    // 6. Reset Form ke Kondisi Awal
    private void clearForm() {
        idField.setText("");
        namaField.setText("");
        tahunLahirField.setText("");
        kategoriComboBox.setSelectedIndex(0);
        genderComboBox.setSelectedIndex(0);

        selectedIndex = -1;
        addUpdateButton.setText("Add/Update");
        //deleteButton.setVisible(false);
    }

    // 7. Method Main untuk Menjalankan Form
    public static void main(String[] args) {
        PeopleMenu window = new PeopleMenu();
        window.setSize(750, 600);
        window.setLocationRelativeTo(null);
        window.setContentPane(window.mainPanel);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}