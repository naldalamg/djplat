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
			System.out.println("����� �����ϼ���. \n 1.ȸ�� ����, 2. ����ī ����, 3. �������, 4.�Ϸ�");
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

		System.out.println("���� ����� �����ϼ���. \n 1.ȸ�����, 2.ȸ����ȸ, 3.ȸ������, 4.ȸ������, 5.�ǵ��ư���");

		Scanner scanner = new Scanner(System.in);
		selectItem = Integer.parseInt(scanner.nextLine());
		switch (selectItem) {
		case 1:
			String data = null;
			System.out.println("ȸ�� ������ �Է��ϼ���.");

			customerVo = new CustomerVo();
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("���̵� �Է��ϼ���: ");
			data = in.readLine();
			customerVo.setId(data);

			System.out.println("��й�ȣ�� �Է��ϼ���: ");
			data = in.readLine();
			customerVo.setPassword(data);

			System.out.println("�̸��� �Է��ϼ���: ");
			data = in.readLine();
			customerVo.setName(data);

			System.out.println("�ּҸ� �Է��ϼ���: ");
			data = in.readLine();
			customerVo.setAddress(data);

			System.out.println("��ȭ��ȣ�� �Է��ϼ���: ");
			data = in.readLine();
			customerVo.setPhoneNum(data);

			customer.regCustomer(customerVo);
			break;

		case 2:
			String memData = customer.checkCustomer(customerVo);
			System.out.println("ȸ������: ");
			System.out.println("============================");
			System.out.println(memData);
			break;

		case 5:
			break;
		}
	}
}
