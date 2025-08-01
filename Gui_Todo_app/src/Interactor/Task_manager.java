package Interactor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Task_manager extends JFrame {

	private JTextField taskField;
	private JButton addButton, deleteButton;
	private DefaultListModel<String> taskListModel;
	private JList<String> taskList;

	public Task_manager() {
		setTitle("Task Manager");
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		JPanel inputPanel = new JPanel();
		taskField = new JTextField(20);
		addButton = new JButton("Add Task");
		inputPanel.add(taskField);
		inputPanel.add(addButton);

		taskListModel = new DefaultListModel<>();
		taskList = new JList<>(taskListModel);
		JScrollPane scrollPane = new JScrollPane(taskList);

		JPanel deletePanel = new JPanel();
		deleteButton = new JButton("Delete Task");
		deletePanel.add(deleteButton);

		add(inputPanel, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		add(deletePanel, BorderLayout.SOUTH);

		addButton.addActionListener(e -> {
			String task = taskField.getText().trim();
			if (!task.isEmpty()) {
				taskListModel.addElement(task);
				taskField.setText("");
			}
		});

		
		deleteButton.addActionListener(e -> {
			int selectedIndex = taskList.getSelectedIndex();
			if (selectedIndex != -1) {
				taskListModel.remove(selectedIndex);
			}
		});

		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(Task_manager::new);

	}
}
