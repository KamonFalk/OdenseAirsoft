import javafx.beans.InvalidationListener;
import javafx.beans.property.ObjectProperty;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


/**
 * Created by Falk on 09/05/2016.
 */
public class ChooseWareToEdit {

    Stage chooseWareToEditObject;

    //Retrieves a list of wares from the database the user then selects a ware from to edit
    public void chooseWareToEdit(){

        chooseWareToEditObject = new Stage();

        ObservableList<Wares> wareList = new ObservableList<Wares>() {


            @Override
            public void addListener(InvalidationListener listener) {

            }

            @Override
            public void removeListener(InvalidationListener listener) {

            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Wares> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Wares wares) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Wares> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Wares> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Wares get(int index) {
                return null;
            }

            @Override
            public Wares set(int index, Wares element) {
                return null;
            }

            @Override
            public void add(int index, Wares element) {

            }

            @Override
            public Wares remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Wares> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Wares> listIterator(int index) {
                return null;
            }

            @Override
            public List<Wares> subList(int fromIndex, int toIndex) {
                return null;
            }

            @Override
            public void addListener(ListChangeListener<? super Wares> listener) {

            }

            @Override
            public void removeListener(ListChangeListener<? super Wares> listener) {

            }

            @Override
            public boolean addAll(Wares... elements) {
                return false;
            }

            @Override
            public boolean setAll(Wares... elements) {
                return false;
            }

            @Override
            public boolean setAll(Collection<? extends Wares> col) {
                return false;
            }

            @Override
            public boolean removeAll(Wares... elements) {
                return false;
            }

            @Override
            public boolean retainAll(Wares... elements) {
                return false;
            }

            @Override
            public void remove(int from, int to) {

            }

        };

        TableView table = new TableView();
        table.toFront();
        table.setEditable(true);
        table.autosize();
        table.setPadding(new Insets(15, 0, 0, 0));

        Wares a = new Wares("Hej", 2, 2);
        Wares b = new Wares("Hej", 2, 2);
        Wares c = new Wares("Hej", 2, 2);
        Wares d = new Wares("Hej", 2, 2);
        Wares e = new Wares("Hej", 2, 2);
        Wares f = new Wares("Hej", 2, 2);
        Wares g = new Wares("Hej", 2, 2);
        Wares h = new Wares("Hej", 2, 2);
        Wares j = new Wares("Hej", 2, 2);
        Wares k = new Wares("Hej", 2, 2);

        table.setItems(wareList);

        TableColumn<Wares, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Wares, String>("firstName"));
        TableColumn<Wares,String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Wares, String>("lastName"));

        table.getColumns().setAll(firstNameCol, lastNameCol);

        StackPane sp = new StackPane();
        sp.setId("backgroundDefault");
        Scene chooseWareToEditScene = new Scene(sp, 500, 500);
        chooseWareToEditScene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        chooseWareToEditObject.setTitle("Odense Airsoft alpha 1.0 - Valg af vare til redigering");
        chooseWareToEditObject.setScene(chooseWareToEditScene);
        chooseWareToEditObject.setOnCloseRequest(event -> {
            event.consume();
            closeProgram();
        });
        chooseWareToEditObject.initModality(Modality.APPLICATION_MODAL);
        chooseWareToEditObject.show();

    }
    public void closeProgram(){

        Boolean answer = ConfirmBox.display("Luk", "Er du sikker på, at du vil lukke?");

        if (answer.equals(true)) {
            chooseWareToEditObject.close();
        }
    }
}
