package rent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import rent.common.exception.RentException;
import rent.customer.Customer;
import rent.customer.CustomerImpl;
import rent.customer.CustomerVo;

public class RentTest {

	public static void main(String[] args) {

		String cusInfo;
		String carInfo;
		String resInfo;

		int selectItem = 1;

		while (true) {
			System.out.println("기능을 선택하세요. \n 1.회원 관리, 2. 렌터카 관리, 3. 예약관리, 4.완료");
			Scanner scanner = new Scanner(System.in);
			selectItem = Integer.parseInt(scanner.nextLine());

			switch (selectItem) {
			case 1:
				try {
					customer();
				} catch (RentException e) {
					e.getRentExceptionInfo();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 2:
				break;
			case 3:
				break;
			case 4:
				System.exit(1);
				break;
			}
		}
	}

	private static void customer() throws IOException, RentException {
		Customer customer = new CustomerImpl();
		CustomerVo customerVo = null;
		int selectItem = 1;

		System.out.println("세부 기능을 선택하세요. \n 1.회원등록, 2.회원조회, 3.회원수정, 4.회원삭제, 5.되돌아가기");

		Scanner scanner = new Scanner(System.in);
		selectItem = Integer.parseInt(scanner.nextLine());
		switch (selectItem) {
		case 1:
			String data = null;
			System.out.println("회원 정보를 입력하세요.");

			customerVo = new CustomerVo();
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("아이디를 입력하세요: ");
			data = in.readLine();
			customerVo.setId(data);

			System.out.println("비밀번호를 입력하세요: ");
			data = in.readLine();
			customerVo.setPassword(data);

			System.out.println("이름을 입력하세요: ");
			data = in.readLine();
			customerVo.setName(data);

			System.out.println("주소를 입력하세요: ");
			data = in.readLine();
			customerVo.setAddress(data);

			System.out.println("전화번호를 입력하세요: ");
			data = in.readLine();
			customerVo.setPhoneNum(data);

			customer.regCustomer(customerVo);
			break;

		case 2:
			String memData = customer.checkCustomer(customerVo);
			System.out.println("회원정보: ");
			System.out.println("============================");
			System.out.println(memData);
			break;

		case 5:
			break;
		}
	}
}
