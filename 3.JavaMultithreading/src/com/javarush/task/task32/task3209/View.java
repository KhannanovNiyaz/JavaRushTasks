package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Графический интерфейс будет представлять собой окно, в котором будет меню и панель с
 * двумя вкладками.
 * На первой вкладке будет располагаться текстовая панель, которая будет отрисовывать html страницу. На ней можно
 * будет форматировать и редактировать текст страницы.
 * На второй вкладке будет редактор, который будет отображать код html страницы, в нем будут видны все используемые
 * html теги. В нем также можно будет менять текст страницы, добавлять и удалять различные теги.
 */

/*
Реализуем метод actionPerformed(ActionEvent actionEvent) у представления, этот метод наследуется от интерфейса ActionListener
и будет вызваться при выборе пунктов меню, у которых наше представление указано в виде слушателя событий.
19.1. Получи из события команду с помощью метода getActionCommand(). Это будет обычная строка. По этой строке ты можешь понять
какой пункт меню создал данное событие.
19.2. Если это команда "Новый", вызови у контроллера метод createNewDocument(). В этом пункте и далее, если необходимого метода
в контроллере еще нет - создай заглушки.
19.3. Если это команда "Открыть", вызови метод openDocument().
19.4. Если "Сохранить", то вызови saveDocument().
19.5. Если "Сохранить как..." - saveDocumentAs().
19.6. Если "Выход" - exit().
19.7. Если "О программе", то вызови метод showAbout() у представления.
Проверь, что заработали пункты меню Выход и О программе.

Требования:
1. Метод actionPerformed(ActionEvent actionEvent) должен получать из события команду с помощью метода getActionCommand().
2. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "Новый", метод должен вызывать у
контроллера createNewDocument().
3. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "Открыть", метод должен вызывать у
контроллера openDocument().
4. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "Сохранить", метод должен вызывать у
контроллера saveDocument().
5. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "Сохранить как...", метод должен вызывать
 у контроллера saveDocumentAs().
6. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "Выход", метод должен вызывать у контроллера
exit().
7. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "О программе", метод должен вызывать у
 представления showAbout().
* */

public class View extends JFrame implements ActionListener {
    private JEditorPane plainTextPane = new JEditorPane();
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private Controller controller;
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()) {
            case "Новый":
                controller.createNewDocument();
                break;
            case "Открыть":
                controller.openDocument();
                break;
            case "Сохранить":
                controller.saveDocument();
                break;
            case "Сохранить как...":
                controller.saveDocumentAs();
                break;
            case "Выход":
                controller.exit();
                break;
            case "О программе":
                showAbout();
        }
    }

    public void selectedTabChanged() {
        switch (tabbedPane.getSelectedIndex()) {
            case 0:
                controller.setPlainText(plainTextPane.getText());
                break;
            case 1:
                plainTextPane.setText(controller.getPlainText());
                break;
        }
        resetUndo();
    }


    public void selectHtmlTab() {
        tabbedPane.setSelectedIndex(0);
        resetUndo();

    }

    // обновляет html страницу
    public void update() {
        htmlTextPane.setDocument(controller.getDocument());
    }

    // "О программе"
    public void showAbout() {
        JOptionPane.showMessageDialog(getContentPane(), "It hard to be God", "Information", JOptionPane.INFORMATION_MESSAGE);
    }


    public boolean isHtmlTabSelected() {
        return tabbedPane.getSelectedIndex() == 0;
    }

    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public void undo() { // отменяет последнее действие.
        try {
            undoManager.undo();
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public void redo() { //возвращает ранее отмененное действие.
        try {
            undoManager.redo();
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public boolean canUndo() {
        return undoManager.canUndo();
    }

    public boolean canRedo() {
        return undoManager.canRedo();
    }

    public void resetUndo() {
        undoManager.discardAllEdits();
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
    
    public void init() {
        initGui();
        addWindowListener(new FrameListener(this));
        this.setVisible(true);
    }

    public void exit() {
        controller.exit();
    }

    public void initMenuBar() {
//        за инициализацию меню  Файл, Редактировать, Стиль, Выравнивание, Цвет, Шрифт и Помощь.
        JMenuBar jMenuBar = new JMenuBar();
        MenuHelper.initFileMenu(this, jMenuBar);
        MenuHelper.initEditMenu(this, jMenuBar);
        MenuHelper.initStyleMenu(this, jMenuBar);
        MenuHelper.initAlignMenu(this, jMenuBar);
        MenuHelper.initColorMenu(this, jMenuBar);
        MenuHelper.initFontMenu(this, jMenuBar);
        MenuHelper.initHelpMenu(this, jMenuBar);
        getContentPane().add(jMenuBar, BorderLayout.NORTH);
    }

    public void initEditor() {
//        отвечать за инициализацию панелей редактора.
        htmlTextPane.setContentType("text/html");
        tabbedPane.add("HTML", new JScrollPane(htmlTextPane));
        tabbedPane.add("Текст", new JScrollPane(plainTextPane));
        tabbedPane.setPreferredSize(new Dimension(100, 100));
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));
        this.getContentPane().add(tabbedPane, BorderLayout.CENTER);

    }

    @Override
    public void pack() {
        super.pack();
    }

    public void initGui() {
        initMenuBar();
        initEditor();
        pack();
    }


}
