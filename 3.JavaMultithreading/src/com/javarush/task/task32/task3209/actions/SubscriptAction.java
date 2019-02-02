package com.javarush.task.task32.task3209.actions;

import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

/*
12.3. Изучи реализацию класса StrikeThroughAction, которую ты получил вместе с заданием и реализуй аналогичным образом классы:
12.3.1. SubscriptAction
12.3.2. SuperscriptAction
Запусти программу и убедись, что пункты меню Подстрочный знак, Надстрочный знак и Зачеркнутый работают. Пункты,
отвечающие за отмену и возврат действия пока не подключены к контроллеру и мы не сможем их проверить.

Требования:
8. Метод actionPerformed(ActionEvent actionEvent) класса SubscriptAction должен использовать метод setSubscript у StyleConstants
с параметрами: SimpleAttributeSet и !StyleConstants.isSubscript(mutableAttributeSet).
9.Конструктор без параметров класса SuperscriptAction должен вызывать конструктор суперкласса с параметром StyleConstants.Superscript.
10.Метод actionPerformed(ActionEvent actionEvent) класса SuperscriptAction должен использовать метод setSuperscript у StyleConstants
 с параметрами: SimpleAttributeSet и !StyleConstants.isSuperscript(mutableAttributeSet).
* */

public class SubscriptAction extends StyledEditorKit.StyledTextAction {
    public SubscriptAction() {
        super(StyleConstants.Subscript.toString());
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JEditorPane editor = getEditor(actionEvent);
        if (editor != null) {
            MutableAttributeSet mutableAttributeSet = getStyledEditorKit(editor).getInputAttributes();
            SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
            StyleConstants.setSubscript(simpleAttributeSet, !StyleConstants.isSubscript(mutableAttributeSet));
            setCharacterAttributes(editor, simpleAttributeSet, false);
        }
    }
}


/*
* Убедись, что метод actionPerformed(ActionEvent actionEvent) вызывает метод setSubscript у StyleConstants с параметрами:
* SimpleAttributeSet и !StyleConstants.isSubscript(mutableAttributeSet).
* */