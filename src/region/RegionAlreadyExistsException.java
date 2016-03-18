package region;

public class RegionAlreadyExistsException extends RuntimeException {
	 public RegionAlreadyExistsException(){
		 super("There is already a region with this Zone Number!");
	 }
}
