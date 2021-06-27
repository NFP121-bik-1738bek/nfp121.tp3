package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    /** par délégation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacité de la pile */
    private int capacite;

    /** Création d'une pile.
     * @param taille la "taille maximale" de la pile, doit être > 0
     */
    public Pile2(int taille) {
        if(taille <= 0){
            capacite = PileI.CAPACITE_PAR_DEFAUT;
        }else{
            capacite = taille;
        }
        
        stk = new Stack();
    }

    public Pile2() {
        // à compléter
        this(0);
    }

    public void empiler(T o) throws PilePleineException {
        // à compléter
        if(estPleine()) {
            throw new PilePleineException();
        }
        stk.push(o);
    }

    public T depiler() throws PileVideException {
        // à compléter
        if(estVide()) {
            throw new PileVideException();
        }
        return stk.pop();
    }

    
    public T sommet() throws PileVideException {
        if(estVide()) {
            throw new PileVideException();
        }
        return stk.peek();
    }

    // recopier ici toutes les autres méthodes
    // qui ne sont pas modifiées en fonction
    // du type des éléments de la pile
    public String toString() {
        String s = "[";
        // a completer
        for (int i = this.taille() - 1; i >= 0; i--) {
            s += this.stk.elementAt(i).toString();
            if (i > 0) {
                s += ", ";
            }
        }
        return s + "]";
    }
    
    public boolean equals(Object o) {
        // a completer
        if(o instanceof Pile2) {
            Pile2 temp;
            temp = (Pile2)o;
                
            if (this.capacite() != temp.capacite() || this.taille() != temp.taille()) {
                return false;
            }
            
            for(int i =0; i < this.taille(); i++) {
                if(!this.stk.elementAt(i).equals(temp.stk.elementAt(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    public boolean estPleine() {
        if(stk.size() == capacite){
            return true;
        }
        return false;
    }
    
    public boolean estVide() {
        if(stk.size() == 0){
            return true;
        }
        return false;
    }
     
    public int hashCode(){
        return toString().hashCode();
    }
    
    public int capacite(){
        return capacite;
    }
    
    public int taille(){
        return stk.size();
    }
} // Pile2