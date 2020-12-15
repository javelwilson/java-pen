import org.springframework.beans.support.PagedListHolder;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListPaging {
    public static void main(String[] args) {
        List list = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        int page;
        int pageSize;

        Scanner scanner = new Scanner(System.in);
        String  control = "y";

        while (!control.equalsIgnoreCase("n")) {

            // -- console interaction
            System.out.print("\ncompleteList: ");
            System.out.println(list.stream().collect(Collectors.toList()));

            System.out.println("Enter the page number");
            page = scanner.nextInt();

            System.out.println("Enter the page size");
            pageSize = scanner.nextInt();
            // --

            // -- paging solution
            PagedListHolder pagedListHolder = new PagedListHolder(list);

            pagedListHolder.setPageSize(pageSize);
            pagedListHolder.setPage(page);

            List pagedList = pagedListHolder.getPageList();
            // --

            // -- display
            System.out.print("\npage" + "(" + page + "): ");
            System.out.println(pagedList.stream().collect(Collectors.toList()));

            System.out.println("currentPage: " + pagedListHolder.getPage());

            System.out.println("isFirstPage: " + pagedListHolder.isFirstPage());

            System.out.println("isLastPage: " + pagedListHolder.isLastPage());

            System.out.println("currentPageSize: " + pagedList.size());

            System.out.println("pageCount: " + pagedListHolder.getPageCount());

            System.out.println("\nContinue? (any key/n)");
            control = scanner.next();
            if (control.equalsIgnoreCase("n")) {
                scanner.close();
            }
            // --
        }
    }
}
