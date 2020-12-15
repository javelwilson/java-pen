import org.springframework.beans.support.PagedListHolder;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListPaging {
    public static void main(String[] args) {

        List list = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

        PagedListHolder pagedListHolder = new PagedListHolder(list);

        System.out.print("Complete List: ");
        System.out.println(list.stream().collect(Collectors.toList()));

        int pageSize = 2;
        int page = 4;

        pagedListHolder.setPageSize(pageSize);
        pagedListHolder.setPage(page);

        List pagedList = pagedListHolder.getPageList();

        System.out.print("\nPaged List " + "(" + page + "): ");
        System.out.println(pagedList.stream().collect(Collectors.toList()));

        System.out.println("\nPage Count: " + pagedListHolder.getPageCount());

        System.out.println("\nIs First Page: " + pagedListHolder.isFirstPage());

        System.out.println("\nIs Last Page: " + pagedListHolder.isLastPage());

        System.out.println("\nCurrent Page: " + pagedListHolder.getPage());

        System.out.println("\nCurrent Page Size: " + pagedList.size());

    }
}
