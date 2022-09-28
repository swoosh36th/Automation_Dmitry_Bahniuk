package pageObjects.herokuapp;

public enum NavigationItem {
    DYNAMIC_LOADING("Dynamic Loading"),
    INFINITE_SCROLL("Infinite Scroll"),
    CONTEXT_MENU("Context Menu"),
    DYNAMIC_CONTROLS("Dynamic Controls"),
    FRAMES("Frames"),
    FILE_UPLOAD("File Upload"),
    ADD_REMOVE_ELEMENTS("Add/Remove Elements"),
    DROPDOWN_LIST("Dropdown"),
    DRAG_AND_DROP("Drag and Drop"),
    MULTIPLE_WINDOWS("Multiple Windows");

    private String item;
    NavigationItem(String item) {
        this.item = item;
    }
    public String getItem(){
        return item;
    }
}
