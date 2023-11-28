package ru.job4j.tracker;

public class CreateManyItems implements UserAction {
    private final Output out;

    public CreateManyItems(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create many items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Create many items ===");
        int count = input.askInt("Enter items amount: ");
        for (int i = 0; i < count; i++) {
            tracker.add(new Item("Item #" + i));
        }
        out.println("Items were added: " + count);
        return true;
    }
}