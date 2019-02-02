package com.javarush.task.task32.task3209.listeners;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

/*
* метод public void undoableEditHappened(UndoableEditEvent e) должен из переданного события получать
* правку(getEdit()) и добавлять ее в undoManager(addEdit()).
*
* Метод undoableEditHappened(UndoableEditEvent e) в классе UndoListener должен из
* переданного события получать правку и добавлять ее в undoManager.
* */

public class UndoListener implements UndoableEditListener {
    private UndoManager undoManager;

    public UndoListener(UndoManager undoManager) {
        this.undoManager = undoManager;
    }

    public void undoableEditHappened(UndoableEditEvent e){
        undoManager.addEdit(e.getEdit());
    }
}
