/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questao02;

/**
 *
 * @author jorge
 */

import lista.ListaLigada;
import lista.Elemento;
import java.util.Comparator;

public class ListaLigadaOrdenada<TIPO> extends ListaLigada<TIPO> {

    public Elemento<TIPO> mergeSort(Elemento<TIPO> node, Comparator<TIPO> comparator) {
    if (node == null || node.getProximo() == null) {
        return node;
    }

    Elemento<TIPO> middle = getMiddle(node);
    Elemento<TIPO> middleProximo = middle.getProximo();

    middle.setProximo(null);
    middleProximo.setAnterior(null);

    Elemento<TIPO> left = mergeSort(node, comparator);
    Elemento<TIPO> right = mergeSort(middleProximo, comparator);

    Elemento<TIPO> sortedList = merge(left, right, comparator);
    setPrimeiro(sortedList);
 
    Elemento<TIPO> temp = sortedList;
    while (temp.getProximo() != null) {
        temp = temp.getProximo();
    }
    setUltimo(temp);  

    return sortedList;
}


    public Elemento<TIPO> merge(Elemento<TIPO> a, Elemento<TIPO> b, Comparator<TIPO> comparator) {
    Elemento<TIPO> result = null;
    Elemento<TIPO> tail = null; 

    while (a != null && b != null) {
        Elemento<TIPO> next = null;
        if (comparator.compare(a.getValor(), b.getValor()) <= 0) {
            next = a;
            a = a.getProximo();
        } else {
            next = b;
            b = b.getProximo();
        }

        if (result == null) {
            result = next;
            tail = result;
        } else {
            tail.setProximo(next);
            next.setAnterior(tail);
            tail = next;
        }
    }

    if (a != null) {
        tail.setProximo(a);
        a.setAnterior(tail);
    } else if (b != null) {
        tail.setProximo(b);
        b.setAnterior(tail);
    }

    return result;
}



    private Elemento<TIPO> getMiddle(Elemento<TIPO> head) {
        if (head == null) {
            return head;
        }
        Elemento<TIPO> slow = head, fast = head;

        while (fast.getProximo() != null && fast.getProximo().getProximo() != null) {
            slow = slow.getProximo();
            fast = fast.getProximo().getProximo();
        }
        return slow;
    }

    public void sort(Comparator<TIPO> comparator) {
        if (getPrimeiro() != null) {
            setPrimeiro(mergeSort(getPrimeiro(), comparator));
        }
    }
}

