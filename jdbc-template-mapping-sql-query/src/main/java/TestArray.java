import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestArray {

	public static void main(String[] args) throws IOException {
		List<String> lines = Files.lines(Paths.get("D:\\RbcUatRoutines.txt"))
				.filter(l -> l.contains("lnd22"))
				.collect(Collectors.toList());
		
		lines.forEach(System.out::println);
				
				
		
		
	}
	

}

// [ 419, 420, 421, 425 ]