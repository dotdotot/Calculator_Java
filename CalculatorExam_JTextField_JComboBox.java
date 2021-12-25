
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorExam_JTextField_JComboBox extends JFrame {
	public JLabel titleLabel = new JLabel("계산기");
	// 첫번째 숫자를 입력받는 textField
	public JLabel textLabel1 = new JLabel("첫 번째 숫자");
	public JTextField text1 = new JTextField("", 20);
	// 두번째 숫자를 입력받는 textField
	public JLabel textLabel2 = new JLabel("두 번째 숫자");
	public JTextField text2 = new JTextField("", 20);
	// 연산자 배열
	public String[] operArr = { "+", "-", "*", "/" };
	// 연산자 콤보박스
	public JComboBox<String> oper = new JComboBox<String>(operArr);
	// 결과 레이블
	public JTextField result = new JTextField("결과");

	public CalculatorExam_JTextField_JComboBox() {
		// 제목설정, 메인스레드 종료시 이벤트스레드도 종료하도록 설정
		super("계산기 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 프레임을 화면 가운대 배치
		setLocationRelativeTo(null);

		// 컨테이너의 이름을 c로 설정, 배치관리자 삭제
		Container c = getContentPane();
		c.setLayout(null);

		// (결과레이블, 결과과정을 보여주는 레이블, 제목레이블, 버튼에 들어가는 텍스트)폰트 설정
		Font resultFont = new Font("Aharoni 굵게", Font.BOLD, 17);
		Font processFont = new Font("Aharoni 굵게", Font.BOLD, 17);
		Font titleFont = new Font("Aharoni 굵게", Font.BOLD, 17);
		Font font = new Font("Aharoni 굵게", Font.BOLD, 13);

		// 기본바탕, 숫자버튼, 연산자버튼, 결과버튼 색깔설정
		Color mainColor = new Color(238, 238, 238);
		// 기본바탕 색상 초기화
		c.setBackground(mainColor);

		// 제목의 위치,폰트설정
		titleLabel.setBounds(10, 10, 100, 30);
		titleLabel.setFont(titleFont);

		// 텍스트1을 설명하는 레이블의 위치와 폰트설정
		textLabel1.setBounds(10, 20, 200, 30);
		textLabel1.setFont(font);

		// 텍스트1에 액션리스너 부착, 마우스리스너 부착, 위치, 폰트 설정
		text1.addActionListener(oper);
		text1.addMouseListener(new MyMouseListener());
		text1.setBounds(10, 50, 200, 30);
		text1.setFont(processFont);

		// 텍스트2를 설명하는 레이블의 위치와 폰트설정
		textLabel2.setBounds(10, 120, 200, 30);
		textLabel2.setFont(font);

		// 텍스트2에 액션리스너 부착, 마우스리스너 부착, 위치, 폰트 설정
		text2.addActionListener(oper);
		text2.addMouseListener(new MyMouseListener());
		text2.setBounds(10, 150, 200, 30);
		text2.setFont(processFont);

		// 연산자 콤보박스의 위치 설정과 액션 리스너 부착
		oper.setBounds(250, 100, 50, 30);
		oper.addActionListener(new OperActionListener());

		// 결과를 출력하는 레이블의 위치와 폰트설정(읽기전용으로 설정)
		result.setBounds(350, 100, 200, 30);
		result.setEditable(false);
		result.setFont(resultFont);

		// 컨테이너에 컴포넌트들 부착
		c.add(textLabel1);
		c.add(text1);
		c.add(textLabel2);
		c.add(text2);
		c.add(oper);
		c.add(result);

		// 사이즈 설정, 창 표시
		setSize(600, 250);
		setVisible(true);
	}

	class MyMouseListener extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			JTextField tf = (JTextField) e.getSource();
			// 만약 예외처리가 발생해서 텍스트가 "다시 입력해주세요"인 경우
			if (tf.getText().equals("다시 입력해주세요")) {
				tf.setText("");
			}
		}
	}


	// OperActionListener Class
	class OperActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String s = oper.getSelectedItem().toString();
			// + 연산자일 경우
			if (s.equals("+")) {
				// .뒤에 정상적으로 입력받을 수 있도록 도와줌
				String textNum1 = PointBackNull(text1.getText());
				text1.setText(String.valueOf(textNum1));
				String textNum2 = PointBackNull(text2.getText());
				text2.setText(String.valueOf(textNum2));

				// 예외처리 발생시 처리(숫자를 실수형으로 변환)
				double num1 = NumberFormatException(textNum1);
				double num2 = NumberFormatException(textNum2);

				// 예외처리 발생시
				if (num1 == -123456789.333 || num2 == -123456789.333) {
					result.setText("오류발생");
					return;
				}

				// 결과값을 담는 변수
				double resultNum = num1 + num2;

				// 결과값이 실수일 경우
				if (minusNumCheck(resultNum)) {
					// 결과값 출력
					result.setText(String.valueOf(resultNum));
				}
				// 결과값이 정수일 경우
				else {
					// 결과값 출력
					result.setText(String.valueOf((int) resultNum));
				}
			}
			// - 연산자일 경우
			else if (s.equals("-")) {
				// .뒤에 정상적으로 입력받을 수 있도록 도와줌
				String textNum1 = PointBackNull(text1.getText());
				text1.setText(String.valueOf(textNum1));
				String textNum2 = PointBackNull(text2.getText());
				text2.setText(String.valueOf(textNum1));

				// 예외처리 발생시 처리(숫자를 실수형으로 변환)
				double num1 = NumberFormatException(textNum1);
				double num2 = NumberFormatException(textNum2);

				// 예외처리 발생시
				if (num1 == -123456789.333 || num2 == -123456789.333) {
					result.setText("오류발생");
					return;
				}

				// 결과값을 담는 변수
				double resultNum = num1 - num2;

				// 결과값이 실수일 경우
				if (minusNumCheck(resultNum)) {
					// 결과값 출력
					result.setText(String.valueOf(resultNum));
				}
				// 결과값이 정수일 경우
				else {
					// 결과값 출력
					result.setText(String.valueOf((int) resultNum));
				}
			}
			// * 연산자일 경우
			else if (s.equals("*")) {
				// .뒤에 정상적으로 입력받을 수 있도록 도와줌
				String textNum1 = PointBackNull(text1.getText());
				text1.setText(String.valueOf(textNum1));
				String textNum2 = PointBackNull(text2.getText());
				text2.setText(String.valueOf(textNum1));

				// 예외처리 발생시 처리(숫자를 실수형으로 변환)
				double num1 = NumberFormatException(textNum1);
				double num2 = NumberFormatException(textNum2);

				// 예외처리 발생시
				if (num1 == -123456789.333 || num2 == -123456789.333) {
					result.setText("오류발생");
					return;
				}

				// 결과값을 담는 변수
				double resultNum = num1 * num2;

				// 결과값이 실수일 경우
				if (minusNumCheck(resultNum)) {
					// 결과값 출력
					result.setText(String.valueOf(resultNum));
				}
				// 결과값이 정수일 경우
				else {
					// 결과값 출력
					result.setText(String.valueOf((int) resultNum));
				}
			}
			// / 연산자일 경우
			else if (s.equals("/")) {
				// .뒤에 정상적으로 입력받을 수 있도록 도와줌
				String textNum1 = PointBackNull(text1.getText());
				text1.setText(String.valueOf(textNum1));
				String textNum2 = PointBackNull(text2.getText());
				text2.setText(String.valueOf(textNum1));

				// 예외처리 발생시 처리(숫자를 실수형으로 변환)
				double num1 = NumberFormatException(textNum1);
				double num2 = NumberFormatException(textNum2);

				// 예외처리 발생시
				if (num1 == -123456789.333 || num2 == -123456789.333) {
					result.setText("오류발생");
					return;
				}

				// 결과값을 담는 변수
				double resultNum = num1 / num2;

				// 결과값이 실수일 경우
				if (minusNumCheck(resultNum)) {
					// 결과값 출력
					result.setText(String.valueOf(resultNum));
				}
				// 결과값이 정수일 경우
				else {
					// 결과값 출력
					result.setText(String.valueOf((int) resultNum));
				}
			}
		}
	}

	// 실수인지 판단해주는 메소드
	public boolean minusNumCheck(double num) {
		// 매개변수로 받은 숫자를 정수형으로 변환하여 변수에담음
		int intNum = (int) num;

		// 실수가 아니라면 false를 반환
		if (intNum == num) {
			return false;
		}
		// 실수라면 true를 반환
		else {
			return true;
		}
	}

	// .뒤에 값을 정상적으로 입력하도록 도와주는 메소드
	public String PointBackNull(String text) {

		// text에 .이 존재하는 경우라면
		if (text.contains(".")) {
			String text1 = text.substring(0, text.length() - 1);
			// 해당 .이 아직 사라지지 않았다면
			if (text1.contains(".")) {
				// .뒤에 어떤 값이든 존재했다는 소리이므로 text 그대로 반환
				return text;
			}
			// 해당 .이 사라졌다면
			else {
				// .뒤에 아무 값도 쓰지않았다는 소리이므로 .을 지운 text1을 반환
				return text1;
			}
		}
		// text에 .이 존재하지 않다면
		else {
			// 그대로 text반환
			return text;
		}
	}

	// 예외처리하는 메소드 수정
	public double NumberFormatException(String text) {
		double num = -123456789.333;
		try {
			num = Double.valueOf(text);
		} catch (Exception e) {
			text1.setText("다시 입력해주세요");
			text2.setText("다시 입력해주세요");
		}

		return num;
	}

	public static void main(String[] args) {
		new CalculatorExam_JTextField_JComboBox();
	}
}