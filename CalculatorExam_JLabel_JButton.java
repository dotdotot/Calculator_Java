// 컴퓨터공학과 1761013 김준석
import java.awt.event.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;

public class CalculatorExam_JLabel_JButton extends JFrame {
	// 접근지정자는 private으로 설정
	// 제목을 나타내는 JLabel 초기값은 "표준계산기"
	private JLabel titleLabel = new JLabel("표준계산기");
	// 계산과정을 나타내는 JLabel 초기값은 "" 오른쪽정렬
	private JLabel processLabel = new JLabel("", SwingConstants.RIGHT);
	// 결과를 나타내는 JLabel 초기값은 "0" 오른쪽정렬
	private JLabel resultLabel = new JLabel("0", SwingConstants.RIGHT);
	// 연산부호가 눌렸는지 체크하는 전역변수
	public static boolean operCheck = false;
	// =을 계속 누를경우 값을 보존해줄 전역변수
	public static double preservedNum = 0;

	public CalculatorExam_JLabel_JButton() {
		// 제목 설정, 메인 프레임 종료시 이벤트 프레임도 종료하도록 설정
		setTitle("계산기 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 프레임을 화면 가운대에 배치
		setLocationRelativeTo(null);

		// CalculatorExam의 컨테이너 이름을 c로 설정, c의 배치관리자를 삭제함, 배경 색상은 하얀색으로 변경
		Container c = getContentPane();
		c.setLayout(null);

		// (결과레이블, 결과과정을 보여주는 레이블, 제목레이블, 버튼에 들어가는 텍스트)폰트 설정
		Font resultFont = new Font("Aharoni 굵게", Font.BOLD, 17);
		Font processFont = new Font("Aharoni 굵게", Font.BOLD, 17);
		Font titleFont = new Font("Aharoni 굵게", Font.BOLD, 17);
		Font font = new Font("Aharoni 굵게", Font.BOLD, 17);

		// 기본바탕, 숫자버튼, 연산자버튼, 결과버튼 색깔설정
		Color mainColor = new Color(238, 238, 238);
		Color numColor = new Color(255, 255, 255);
		Color operColor = new Color(242, 242, 242);
		Color resultColor = new Color(160, 204, 255);
		// 기본바탕 색상 초기화
		c.setBackground(mainColor);

		// 제목, 결과, 결과 과정을 보여주는 레이블의 위치와 폰트설정
		titleLabel.setBounds(10, 10, 100, 30);
		titleLabel.setFont(titleFont);
		processLabel.setBounds(10, 50, 300, 100);
		processLabel.setFont(processFont);
		resultLabel.setBounds(10, 80, 300, 100);
		resultLabel.setFont(resultFont);

		// 플러스 마이너스 부호를 교체해주는 버튼(액션리스너 부착, 위치 설정, 배경색 설정, 폰트 설정)
		JButton buttonPM = new JButton("+/-");
		buttonPM.addActionListener(new P_MActionListener());
		buttonPM.setBounds(9, 415, 80, 50);
		buttonPM.setBackground(numColor);
		buttonPM.setFont(font);
		// 숫자 0버튼(액션리스너 부착, 위치 설정, 배경색 설정, 폰트 설정)
		JButton buttonZero = new JButton("0");
		buttonZero.addActionListener(new NumberActionListner());
		buttonZero.setBounds(89, 415, 80, 50);
		buttonZero.setBackground(numColor);
		buttonZero.setFont(font);
		// .버튼(액션리스너 부착, 위치 설정, 배경색 설정, 폰트 설정)
		JButton buttonPoint = new JButton(".");
		buttonPoint.addActionListener(new PointActionListener());
		buttonPoint.setBounds(169, 415, 80, 50);
		buttonPoint.setBackground(numColor);
		buttonPoint.setFont(font);
		// =버튼(액션리스너 부착, 위치 설정, 배경색 설정, 폰트 설정)
		JButton buttonRes = new JButton("=");
		buttonRes.addActionListener(new ResultActionListener());
		buttonRes.setBounds(249, 415, 80, 50);
		buttonRes.setBackground(resultColor);
		buttonRes.setFont(font);
		// 숫자 1버튼(액션리스너 부착, 위치 설정, 배경색 설정, 폰트 설정)
		JButton buttonOne = new JButton("1");
		buttonOne.addActionListener(new NumberActionListner());
		buttonOne.setBounds(9, 365, 80, 50);
		buttonOne.setBackground(numColor);
		buttonOne.setFont(font);
		// 숫자 2버튼(액션리스너 부착, 위치 설정, 배경색 설정, 폰트 설정)
		JButton buttonTwo = new JButton("2");
		buttonTwo.addActionListener(new NumberActionListner());
		buttonTwo.setBounds(89, 365, 80, 50);
		buttonTwo.setBackground(numColor);
		buttonTwo.setFont(font);
		// 숫자 3버튼(액션리스너 부착, 위치 설정, 배경색 설정, 폰트 설정)
		JButton buttonThree = new JButton("3");
		buttonThree.addActionListener(new NumberActionListner());
		buttonThree.setBounds(169, 365, 80, 50);
		buttonThree.setBackground(numColor);
		buttonThree.setFont(font);
		// +버튼(액션리스너 부착, 위치 설정, 배경색 설정, 폰트 설정)
		JButton buttonPlu = new JButton("+");
		buttonPlu.addActionListener(new OperationActionListener());
		buttonPlu.setBounds(249, 365, 80, 50);
		buttonPlu.setBackground(operColor);
		buttonPlu.setFont(font);
		// 숫자 4버튼(액션리스너 부착, 위치 설정, 배경색 설정, 폰트 설정)
		JButton buttonFour = new JButton("4");
		buttonFour.addActionListener(new NumberActionListner());
		buttonFour.setBounds(9, 315, 80, 50);
		buttonFour.setBackground(numColor);
		buttonFour.setFont(font);
		// 숫자 5버튼(액션리스너 부착, 위치 설정, 배경색 설정, 폰트 설정)
		JButton buttonFive = new JButton("5");
		buttonFive.addActionListener(new NumberActionListner());
		buttonFive.setBounds(89, 315, 80, 50);
		buttonFive.setBackground(numColor);
		buttonFive.setFont(font);
		// 숫자 6버튼(액션리스너 부착, 위치 설정, 배경색 설정, 폰트 설정)
		JButton buttonSix = new JButton("6");
		buttonSix.addActionListener(new NumberActionListner());
		buttonSix.setBounds(169, 315, 80, 50);
		buttonSix.setBackground(numColor);
		buttonSix.setFont(font);
		// -버튼(액션리스너 부착, 위치 설정, 배경색 설정, 폰트 설정)
		JButton buttonMin = new JButton("-");
		buttonMin.addActionListener(new OperationActionListener());
		buttonMin.setBounds(249, 315, 80, 50);
		buttonMin.setBackground(operColor);
		buttonMin.setFont(font);
		// 숫자 7버튼(액션리스너 부착, 위치 설정, 배경색 설정, 폰트 설정)
		JButton buttonSeven = new JButton("7");
		buttonSeven.addActionListener(new NumberActionListner());
		buttonSeven.setBounds(9, 265, 80, 50);
		buttonSeven.setBackground(numColor);
		buttonSeven.setFont(font);
		// 숫자 8버튼(액션리스너 부착, 위치 설정, 배경색 설정, 폰트 설정)
		JButton buttonEight = new JButton("8");
		buttonEight.addActionListener(new NumberActionListner());
		buttonEight.setBounds(89, 265, 80, 50);
		buttonEight.setBackground(numColor);
		buttonEight.setFont(font);
		// 숫자 9버튼(액션리스너 부착, 위치 설정, 배경색 설정, 폰트 설정)
		JButton buttonNine = new JButton("9");
		buttonNine.addActionListener(new NumberActionListner());
		buttonNine.setBounds(169, 265, 80, 50);
		buttonNine.setBackground(numColor);
		buttonNine.setFont(font);
		// *버튼(액션리스너 부착, 위치 설정, 배경색 설정, 폰트 설정)
		JButton buttonMul = new JButton("*");
		buttonMul.addActionListener(new OperationActionListener());
		buttonMul.setBounds(249, 265, 80, 50);
		buttonMul.setBackground(operColor);
		buttonMul.setFont(font);
		// 분에1 버튼(액션리스너 부착, 위치 설정, 배경색 설정, 폰트 설정)
		JButton buttonMPM = new JButton("분에1");
		buttonMPM.addActionListener(new Operation2ActionListener());
		buttonMPM.setBounds(9, 215, 80, 50);
		buttonMPM.setBackground(operColor);
		buttonMPM.setFont(font);
		// 제곱 버튼(액션리스너 부착, 위치 설정, 배경색 설정, 폰트 설정)
		JButton buttonSquare = new JButton("제곱");
		buttonSquare.addActionListener(new Operation2ActionListener());
		buttonSquare.setBounds(89, 215, 80, 50);
		buttonSquare.setBackground(operColor);
		buttonSquare.setFont(font);
		// 루트 버튼(액션리스너 부착, 위치 설정, 배경색 설정, 폰트 설정)
		JButton buttonRoot = new JButton("√");
		buttonRoot.addActionListener(new Operation2ActionListener());
		buttonRoot.setBounds(169, 215, 80, 50);
		buttonRoot.setBackground(operColor);
		buttonRoot.setFont(font);
		// 나누기 버튼(액션리스너 부착, 위치 설정, 배경색 설정, 폰트 설정)
		JButton buttonDiv = new JButton("/");
		buttonDiv.addActionListener(new OperationActionListener());
		buttonDiv.setBounds(249, 215, 80, 50);
		buttonDiv.setBackground(operColor);
		buttonDiv.setFont(font);
		// resultLabel의 내용을 삭제하는 버튼(액션리스너 부착, 위치 설정, 배경색 설정, 폰트 설정)
		JButton buttonCE = new JButton("CE");
		buttonCE.addActionListener(new EraseActionListener());
		buttonCE.setBounds(9, 165, 106, 50);
		buttonCE.setBackground(operColor);
		buttonCE.setFont(font);
		// 모든 내용을 삭제하는 버튼(액션리스너 부착, 위치 설정, 배경색 설정, 폰트 설정)
		JButton buttonC = new JButton("C");
		buttonC.addActionListener(new EraseActionListener());
		buttonC.setBounds(115, 165, 107, 50);
		buttonC.setBackground(operColor);
		buttonC.setFont(font);
		// 하나씩 지우는 버튼(액션리스너 부착, 위치 설정, 배경색 설정, 폰트 설정)
		JButton buttonBack = new JButton("Back");
		buttonBack.addActionListener(new EraseActionListener());
		buttonBack.setBounds(222, 165, 107, 50);
		buttonBack.setBackground(operColor);
		buttonBack.setFont(font);
		// 제목, 결과, 과정 레이블 부착
		c.add(titleLabel);
		c.add(resultLabel);
		c.add(processLabel);
		// 7,8,9,=버튼 부착
		c.add(buttonSeven);
		c.add(buttonEight);
		c.add(buttonNine);
		c.add(buttonMul);
		// 4,5,6,-버튼 부착
		c.add(buttonFour);
		c.add(buttonFive);
		c.add(buttonSix);
		c.add(buttonMin);
		// 1,2,3,+버튼 부착
		c.add(buttonOne);
		c.add(buttonTwo);
		c.add(buttonThree);
		c.add(buttonPlu);
		// +./ 0 . = 버튼 부착
		c.add(buttonPM);
		c.add(buttonZero);
		c.add(buttonPoint);
		c.add(buttonRes);
		// 분에1, 제곱, 루트, 나누기 버튼 부착
		c.add(buttonMPM);
		c.add(buttonSquare);
		c.add(buttonRoot);
		c.add(buttonDiv);
		// CE,C,Back 버튼 부착
		c.add(buttonCE);
		c.add(buttonC);
		c.add(buttonBack);

		// 사이즈설정,창을 표시하도록 설정
		setSize(350, 510);
		setVisible(true);

	}

	class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			new NumberActionListner();
		}
	}

	// 숫자 버튼을 눌렀을 경우 발생하는 이벤트(내부 클래스로 작성)
	class NumberActionListner implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();
			System.out.println("ddd");
			if (operCheck == true) {
				resultLabel.setText("0");
			}

			if (processLabel.getText().contains("=")) {
				resultLabel.setText("0");
				processLabel.setText("");
			}

			if (resultLabel.getText().equals("0으로 나눌 수 없습니다")) {
				resultLabel.setText("0");
				processLabel.setText("");
			}

			// 만약 텍스트가 "0"이라면
			if (resultLabel.getText().equals("0")) {
				resultLabel.setText(btn.getText());
				operCheck = false;
			}
			// 텍스트가 "0"이 아니라면
			else {
				resultLabel.setText(resultLabel.getText() + btn.getText());
				operCheck = false;
			}
		}
	}

	// (+/-) 버튼을 눌렀을 경우 발생하는 이벤트(내부 클래스로 작성)
	class P_MActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			// 만약 텍스트의 내용이 "0"일 경우
			if (resultLabel.getText().equals("0")) {
				// 0을 -를 붙일 수 없기때문에 내부 코드 구현을 하지않음
			}
			// 텍스트의 내용이 "0"이 아닐 경우
			else {
				// 즉 텍스트의 내용에 0이 아닌 다른 숫자가 써져있다는 말과 동일하므로 +/- 기호 변환을 해준다

				// 텍스트에 -가 존재한다면 음수라는 소리와 동일하므로 양수로 교체해준다
				if (resultLabel.getText().contains("-")) {
					String text = resultLabel.getText().substring(1);
					resultLabel.setText(text);
				}
				// 텍스트에 -가 존재하지 않는다면 양수라는 소리와 동일하므로 음수로 교체해준다
				else {
					String text = "-" + resultLabel.getText();
					resultLabel.setText(text);
				}
			}
			operCheck = false;
		}
	}

	// "."을 눌렀을 경우 발생하는 이벤트(내부 클래스로 작성)
	class PointActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// 만약 텍스트에 "."이 존재한다면
			if (resultLabel.getText().contains(".")) {
				// 이미 실수라는 의미와 동일하므로 다시 "."을 붙일 수는 없다.
				// 그렇기에 내부 코드 구현하지않음
			}
			// 텍스트에 "."이 존재하지 않는다면
			else {
				// 실수가 아니라는 의미와 동일하므로 "."을 붙여서 실수로 변환할 수 있다.
				resultLabel.setText(resultLabel.getText() + ".");
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
				resultLabel.setText(text1);
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

	// 연산부호를 눌렀을 경우 발생하는 이벤트(내부 클래스로 작성)(+,-,x,/)
	class OperationActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();

			// 연산부호를 누르고 숫자버튼을 누르지 않은 상태라면
			if (operCheck == true) {
				// 즉 다시 입력하지 않고 연산부호만 지속적으로 누르고 있다는 소리와 동일하다.
				// 만약 연산부호를 바꾸고 싶어서 숫자를 입력하지 않고 연산부호를 누른 상황 처리
				String text = resultLabel.getText();
				if (btn.getText().contains("+")) {
					processLabel.setText(text + " + ");
				} else if (btn.getText().contains("-")) {
					processLabel.setText(text + " - ");
				} else if (btn.getText().contains("*")) {
					processLabel.setText(text + " * ");
				} else if (btn.getText().contains("/")) {
					processLabel.setText(text + " / ");
				}
				// 해당 코드에서 소수점이 존재하는지 판단을 하지 않는이유는
				// 처음 값을 입력하고 연산부호를 눌렀다면 이부분에 들어오지 않고
				// (계산 과정을 보이는 텍스트에 아무 수식도 안써져있는 경우라면)이 부분을 거쳤을것이다.
				// 즉 해당 부분에서 이미 소수점이 존재하는지 확인했을 것 이기때문에 따로 해당 부분에는 확인하는 과정을 넣지 않았다.

			}
			// 연산부호를 누르고 새로 값을 입력한 상태라면
			else {
				// 결과 과정을 보이는 텍스트에 수식이 +라면
				if (processLabel.getText().contains("+")) {
					System.out.println("+");
					// 첫번째 숫자를 가져옴(정상적인 값으로 반환완료)
					String[] textArr = processLabel.getText().split(" ");
					String textNum1 = textArr[0];
					textNum1 = PointBackNull(textNum1);

					// 두번째 숫자를 가져옴(정상적인 값으로 반환완료)
					String textNum2 = resultLabel.getText();
					textNum2 = PointBackNull(textNum2);

					// 첫번째숫자 연산부호 두번째숫자를 했을 때 결과값을 실수형 변수에 담음
					double resultNum_double = Double.valueOf(textNum1) + Double.valueOf(textNum2);
					// 결과값이 실수라면
					if (minusNumCheck(resultNum_double)) {
						// 버튼의 연산부호를 어떤 연산부호를 눌렀는지에 따라 결과 과정을 보여주는 텍스트에 해당 연산부호를 넣어줌
						if (btn.getText().contains("+")) {
							processLabel.setText(String.valueOf(resultNum_double) + " + ");
							resultLabel.setText(String.valueOf(resultNum_double));
						} else if (btn.getText().contains("-")) {
							processLabel.setText(String.valueOf(resultNum_double) + " - ");
							resultLabel.setText(String.valueOf(resultNum_double));
						} else if (btn.getText().contains("*")) {
							processLabel.setText(String.valueOf(resultNum_double) + " * ");
							resultLabel.setText(String.valueOf(resultNum_double));
						} else if (btn.getText().contains("/")) {
							processLabel.setText(String.valueOf(resultNum_double) + " / ");
							resultLabel.setText(String.valueOf(resultNum_double));
						}
					}
					// 결과값이 정수라면
					else {
						// 정수형으로 변환해도 값이 변하는 일은 없으므로 정수형으로 변환
						int resultNum_int = (int) resultNum_double;
						// 버튼의 연산부호를 어떤 연산부호를 눌렀는지에 따라 결과 과정을 보여주는 텍스트에 해당 연산부호를 넣어줌
						if (btn.getText().contains("+")) {
							processLabel.setText(String.valueOf(resultNum_int) + " + ");
							resultLabel.setText(String.valueOf(resultNum_int));
						} else if (btn.getText().contains("-")) {
							processLabel.setText(String.valueOf(resultNum_int) + " - ");
							resultLabel.setText(String.valueOf(resultNum_int));
						} else if (btn.getText().contains("*")) {
							processLabel.setText(String.valueOf(resultNum_int) + " * ");
							resultLabel.setText(String.valueOf(resultNum_int));
						} else if (btn.getText().contains("/")) {
							processLabel.setText(String.valueOf(resultNum_int) + " / ");
							resultLabel.setText(String.valueOf(resultNum_int));
						}
					}
				}
				// 결과 과정을 보이는 텍스트에 수식이 *라면
				else if (processLabel.getText().contains("*")) {
					System.out.println("*");
					System.out.println("222");
					// 첫번째 숫자를 가져옴(정상적인 값으로 반환완료)
					String[] textArr = processLabel.getText().split(" ");
					String textNum1 = textArr[0];
					textNum1 = PointBackNull(textNum1);

					// 두번째 숫자를 가져옴(정상적인 값으로 반환완료)
					String textNum2 = resultLabel.getText();
					textNum2 = PointBackNull(textNum2);

					// 첫번째숫자 연산부호 두번째숫자를 했을 때 결과값을 실수형 변수에 담음
					double resultNum_double = Double.valueOf(textNum1) * Double.valueOf(textNum2);
					// 결과값이 실수라면
					if (minusNumCheck(resultNum_double)) {
						// 버튼의 연산부호를 어떤 연산부호를 눌렀는지에 따라 결과 과정을 보여주는 텍스트에 해당 연산부호를 넣어줌
						if (btn.getText().contains("+")) {
							processLabel.setText(String.valueOf(resultNum_double) + " + ");
							resultLabel.setText(String.valueOf(resultNum_double));
						} else if (btn.getText().contains("-")) {
							processLabel.setText(String.valueOf(resultNum_double) + " - ");
							resultLabel.setText(String.valueOf(resultNum_double));
						} else if (btn.getText().contains("*")) {
							processLabel.setText(String.valueOf(resultNum_double) + " * ");
							resultLabel.setText(String.valueOf(resultNum_double));
						} else if (btn.getText().contains("/")) {
							processLabel.setText(String.valueOf(resultNum_double) + " / ");
							resultLabel.setText(String.valueOf(resultNum_double));
						}
					}
					// 결과값이 정수라면
					else {
						// 정수형으로 변환해도 값이 변하는 일은 없으므로 정수형으로 변환
						int resultNum_int = (int) resultNum_double;
						// 버튼의 연산부호를 어떤 연산부호를 눌렀는지에 따라 결과 과정을 보여주는 텍스트에 해당 연산부호를 넣어줌
						if (btn.getText().contains("+")) {
							processLabel.setText(String.valueOf(resultNum_int) + " + ");
							resultLabel.setText(String.valueOf(resultNum_int));
						} else if (btn.getText().contains("-")) {
							processLabel.setText(String.valueOf(resultNum_int) + " - ");
							resultLabel.setText(String.valueOf(resultNum_int));
						} else if (btn.getText().contains("*")) {
							processLabel.setText(String.valueOf(resultNum_int) + " * ");
							resultLabel.setText(String.valueOf(resultNum_int));
						} else if (btn.getText().contains("/")) {
							processLabel.setText(String.valueOf(resultNum_int) + " / ");
							resultLabel.setText(String.valueOf(resultNum_int));
						}
					}
				}
				// 결과 과정을 보이는 텍스트에 수식이 /라면
				else if (processLabel.getText().contains("/")) {
					System.out.println("/");
					// 첫번째 숫자를 가져옴(정상적인 값으로 반환완료)
					String[] textArr = processLabel.getText().split(" ");
					String textNum1 = textArr[0];
					textNum1 = PointBackNull(textNum1);

					// 두번째 숫자를 가져옴(정상적인 값으로 반환완료)
					String textNum2 = resultLabel.getText();
					textNum2 = PointBackNull(textNum2);

					// 첫번째숫자 연산부호 두번째숫자를 했을 때 결과값을 실수형 변수에 담음
					double resultNum_double = Double.valueOf(textNum1) / Double.valueOf(textNum2);
					// 결과값이 실수라면
					if (minusNumCheck(resultNum_double)) {
						// 버튼의 연산부호를 어떤 연산부호를 눌렀는지에 따라 결과 과정을 보여주는 텍스트에 해당 연산부호를 넣어줌
						if (btn.getText().contains("+")) {
							processLabel.setText(String.valueOf(resultNum_double) + " + ");
							resultLabel.setText(String.valueOf(resultNum_double));
						} else if (btn.getText().contains("-")) {
							processLabel.setText(String.valueOf(resultNum_double) + " - ");
							resultLabel.setText(String.valueOf(resultNum_double));
						} else if (btn.getText().contains("*")) {
							processLabel.setText(String.valueOf(resultNum_double) + " * ");
							resultLabel.setText(String.valueOf(resultNum_double));
						} else if (btn.getText().contains("/")) {
							processLabel.setText(String.valueOf(resultNum_double) + " / ");
							resultLabel.setText(String.valueOf(resultNum_double));
						}
					}
					// 결과값이 정수라면
					else {
						// 정수형으로 변환해도 값이 변하는 일은 없으므로 정수형으로 변환
						int resultNum_int = (int) resultNum_double;
						// 버튼의 연산부호를 어떤 연산부호를 눌렀는지에 따라 결과 과정을 보여주는 텍스트에 해당 연산부호를 넣어줌
						if (btn.getText().contains("+")) {
							processLabel.setText(String.valueOf(resultNum_int) + " + ");
							resultLabel.setText(String.valueOf(resultNum_int));
						} else if (btn.getText().contains("-")) {
							processLabel.setText(String.valueOf(resultNum_int) + " - ");
							resultLabel.setText(String.valueOf(resultNum_int));
						} else if (btn.getText().contains("*")) {
							processLabel.setText(String.valueOf(resultNum_int) + " * ");
							resultLabel.setText(String.valueOf(resultNum_int));
						} else if (btn.getText().contains("/")) {
							processLabel.setText(String.valueOf(resultNum_int) + " / ");
							resultLabel.setText(String.valueOf(resultNum_int));
						}
					}
				} // 결과 과정을 보이는 텍스트에 수식이 -라면
				else if (processLabel.getText().contains("-")) {
					System.out.println("-");
					// 첫번째 숫자를 가져옴(정상적인 값으로 반환완료)
					String[] textArr = processLabel.getText().split(" ");
					String textNum1 = textArr[0];
					textNum1 = PointBackNull(textNum1);

					// 두번째 숫자를 가져옴(정상적인 값으로 반환완료)
					String textNum2 = resultLabel.getText();
					textNum2 = PointBackNull(textNum2);

					// 첫번째숫자 연산부호 두번째숫자를 했을 때 결과값을 실수형 변수에 담음
					double resultNum_double = Double.valueOf(textNum1) - Double.valueOf(textNum2);
					// 결과값이 실수라면
					if (minusNumCheck(resultNum_double)) {
						// 버튼의 연산부호를 어떤 연산부호를 눌렀는지에 따라 결과 과정을 보여주는 텍스트에 해당 연산부호를 넣어줌
						if (btn.getText().contains("+")) {
							processLabel.setText(String.valueOf(resultNum_double) + " + ");
							resultLabel.setText(String.valueOf(resultNum_double));
						} else if (btn.getText().contains("-")) {
							processLabel.setText(String.valueOf(resultNum_double) + " - ");
							resultLabel.setText(String.valueOf(resultNum_double));
						} else if (btn.getText().contains("*")) {
							processLabel.setText(String.valueOf(resultNum_double) + " * ");
							resultLabel.setText(String.valueOf(resultNum_double));
						} else if (btn.getText().contains("/")) {
							processLabel.setText(String.valueOf(resultNum_double) + " / ");
							resultLabel.setText(String.valueOf(resultNum_double));
						}
					}
					// 결과값이 정수라면
					else {
						// 정수형으로 변환해도 값이 변하는 일은 없으므로 정수형으로 변환
						int resultNum_int = (int) resultNum_double;
						// 버튼의 연산부호를 어떤 연산부호를 눌렀는지에 따라 결과 과정을 보여주는 텍스트에 해당 연산부호를 넣어줌
						if (btn.getText().contains("+")) {
							processLabel.setText(String.valueOf(resultNum_int) + " + ");
							resultLabel.setText(String.valueOf(resultNum_int));
						} else if (btn.getText().contains("-")) {
							processLabel.setText(String.valueOf(resultNum_int) + " - ");
							resultLabel.setText(String.valueOf(resultNum_int));
						} else if (btn.getText().contains("*")) {
							processLabel.setText(String.valueOf(resultNum_int) + " * ");
							resultLabel.setText(String.valueOf(resultNum_int));
						} else if (btn.getText().contains("/")) {
							processLabel.setText(String.valueOf(resultNum_int) + " / ");
							resultLabel.setText(String.valueOf(resultNum_int));
						}
					}
				}

				// 계산 과정을 보이는 텍스트에 아무 수식도 안써져있는 경우라면 or 계산과정을 보이는 텍스트에 =이 써져있는 경우라면
				else {
					// 정상적으로 값을 입력할 수 있도록 도와주는 함수를 거쳐 문자열을 받아옴
					String text = PointBackNull(resultLabel.getText());

					if (btn.getText().contains("+")) {
						processLabel.setText(text + " + ");
					} else if (btn.getText().contains("-")) {
						processLabel.setText(text + " - ");
					} else if (btn.getText().contains("*")) {
						processLabel.setText(text + " * ");
					} else if (btn.getText().contains("/")) {
						processLabel.setText(text + " / ");
					}
				}
			}
			operCheck = true;
		}
	}

	// 연산부호를 눌렀을 경우 발생하는 이벤트2(내부 클래스로 작성)(루트,제곱,분에1)
	class Operation2ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();

			// 누른 버튼이 루트버튼일 경우
			if (btn.getText().equals("√")) {
				// 입력한 값이 음수이거나 "입력이 잘못되었습니다" 일 경우
				if (resultLabel.getText().contains("-") || resultLabel.getText().equals("입력이 잘못되었습니다.")) {
					if (operCheck == false) {
						preservedNum = Double.valueOf(resultLabel.getText());
					}

					//
					if (minusNumCheck(preservedNum)) {
						processLabel.setText(String.valueOf(preservedNum));
						resultLabel.setText("입력이 잘못되었습니다.");
					}
					//
					else {
						processLabel.setText(String.valueOf((int) preservedNum));
						resultLabel.setText("입력이 잘못되었습니다.");
					}
				}
				// 정상적으로 숫자를 입력한 경우
				else {
					String textNum = PointBackNull(resultLabel.getText());

					if (operCheck == false) {
						preservedNum = Double.valueOf(textNum);
					}

					double resultNum = Math.sqrt(Double.valueOf(resultLabel.getText()));

					// 결과값이 실수일 경우
					if (minusNumCheck(resultNum)) {
						// 보존하는 값이 실수일 경우
						if (minusNumCheck(preservedNum)) {
							// 계산 과정을 보여주는 텍스트가 비어있을 경우
							if (processLabel.getText().equals("")) {
								processLabel.setText("√(" + preservedNum + ")");
								resultLabel.setText(String.valueOf(resultNum));
							}
							// 계산 과정을 보여주는 텍스트가 비어있지 않은 경우
							else {
								processLabel.setText("√(" + processLabel.getText() + ")");
								resultLabel.setText(String.valueOf(resultNum));
							}
						}
						// 보존하는 값이 실수가 아닌경우
						else {
							// 계산 과정을 보여주는 텍스트가 비어있을 경우
							if (processLabel.getText().equals("")) {
								processLabel.setText("√(" + (int) preservedNum + ")");
								resultLabel.setText(String.valueOf(resultNum));
							}
							// 계산 과정을 보여주는 텍스트가 비어있지 않은 경우
							else {
								processLabel.setText("√(" + processLabel.getText() + ")");
								resultLabel.setText(String.valueOf(resultNum));
							}
						}
					}
					// 결과값이 실수가 아닐 경우
					else {
						// 보존하는 값이 실수일 경우
						if (minusNumCheck(preservedNum)) {
							// 계산 과정을 보여주는 텍스트가 비어있을 경우
							if (processLabel.getText().equals("")) {
								processLabel.setText("√(" + preservedNum + ")");
								resultLabel.setText(String.valueOf((int) resultNum));
							}
							// 계산 과정을 보여주는 텍스트가 비어있지 않은 경우
							else {
								processLabel.setText("√(" + processLabel.getText() + ")");
								resultLabel.setText(String.valueOf((int) resultNum));
							}
						}
						// 보존하는 값이 실수가 아닐 경우
						else {
							// 계산 과정을 보여주는 텍스트가 비어있을 경우
							if (processLabel.getText().equals("")) {
								processLabel.setText("√(" + (int) preservedNum + ")");
								resultLabel.setText(String.valueOf((int) resultNum));
							}
							// 계산 과정을 보여주는 텍스트가 비어있지 않은 경우
							else {
								processLabel.setText("√(" + processLabel.getText() + ")");
								resultLabel.setText(String.valueOf((int) resultNum));
							}
						}
					}
				}
			}

			// 누른 버튼이 제곱버튼일 경우
			else if (btn.getText().equals("제곱")) {
				String text = PointBackNull(resultLabel.getText());

				if (operCheck == false) {
					preservedNum = Double.valueOf(text);
				}

				double resultNum = Double.valueOf(resultLabel.getText()) * Double.valueOf(resultLabel.getText());

				// 결과값이 실수일 경우
				if (minusNumCheck(resultNum)) {
					// 보존되는 값이 실수일 경우
					if (minusNumCheck(preservedNum)) {
						// 계산 과정을 보여주는 텍스트가 비어있을 경우
						if (processLabel.getText().equals("")) {
							processLabel.setText("sqr(" + preservedNum + ")");
							resultLabel.setText(String.valueOf(resultNum));
						}
						// 계산 과정을 보여주는 텍스트가 비어있지 않을 경우
						else {
							processLabel.setText("sqr(" + processLabel.getText() + ")");
							resultLabel.setText(String.valueOf(resultNum));
						}
					}
					// 보존되는 값이 실수가 아닐 경우
					else {
						// 계산 과정을 보여주는 텍스트가 비어있을 경우
						if (processLabel.getText().equals("")) {
							processLabel.setText("sqr(" + (int) preservedNum + ")");
							resultLabel.setText(String.valueOf(resultNum));
						}
						// 계산 과정을 보여주는 텍스트가 비어있지 않을 경우
						else {
							processLabel.setText("sqr(" + processLabel.getText() + ")");
							resultLabel.setText(String.valueOf(resultNum));
						}
					}
				}
				// 결과값이 실수가 아닐 경우
				else {
					// 보존되는 값이 실수일 경우
					if (minusNumCheck(preservedNum)) {
						// 계산 과정을 보여주는 텍스트가 비어있을 경우
						if (processLabel.getText().equals("")) {
							processLabel.setText("sqr(" + preservedNum + ")");
							resultLabel.setText(String.valueOf((int) resultNum));
						}
						// 계산 과정을 보여주는 텍스트가 비어있지 않을 경우
						else {
							processLabel.setText("sqr(" + processLabel.getText() + ")");
							resultLabel.setText(String.valueOf((int) resultNum));
						}
					}
					// 보존되는 값이 실수가 아닐 경우
					else {
						// 계산 과정을 보여주는 텍스트가 비어있을 경우
						if (processLabel.getText().equals("")) {
							processLabel.setText("sqr(" + (int) preservedNum + ")");
							resultLabel.setText(String.valueOf((int) resultNum));
						}
						// 계산 과정을 보여주는 텍스트가 비어있지 않을 경우
						else {
							processLabel.setText("sqr(" + processLabel.getText() + ")");
							resultLabel.setText(String.valueOf((int) resultNum));
						}
					}
				}
			}

			// 분에1 버튼을 선택한 경우
			else if (btn.getText().equals("분에1")) {
				String textNum = PointBackNull(resultLabel.getText());
				// 입력받은 숫자가 0인 경우
				if (textNum.equals("0")) {
					resultLabel.setText("0으로 나눌 수 없습니다");
					processLabel.setText("1/(0)");
				}
				// 입력받은 숫자가 0이 아닌 경우
				else {
					if (operCheck == false) {
						preservedNum = Double.valueOf(textNum);
					}

					double resultNum = 1 / Double.valueOf(textNum);
					// 결과값이 실수일 경우
					if (minusNumCheck(resultNum)) {
						// 보존되는 값이 실수일 경우
						if (minusNumCheck(preservedNum)) {
							// 계산 과정을 보여주는 텍스트가 비어있을 경우
							if (processLabel.getText().equals("")) {
								processLabel.setText("1/(" + preservedNum + ")");
								resultLabel.setText(String.valueOf(resultNum));
							}
							// 계산 과정을 보여주는 텍스트가 비어있지 않을 경우
							else {
								processLabel.setText("1/(" + processLabel.getText() + ")");
								resultLabel.setText(String.valueOf(resultNum));
							}
						}
						// 보존되는 값이 실수가 아닐경우
						else {
							// 계산 과정을 보여주는 텍스트가 비어있을 경우
							if (processLabel.getText().equals("")) {
								processLabel.setText("1/(" + (int) preservedNum + ")");
								resultLabel.setText(String.valueOf(resultNum));
							}
							// 계산 과정을 보여주는 텍스트가 비어있지 않을 경우
							else {
								processLabel.setText("1/(" + processLabel.getText() + ")");
								resultLabel.setText(String.valueOf(resultNum));
							}
						}
					}
					// 결과값이 실수가 아닐 경우
					else {
						// 보존되는 값이 실수일 경우
						if (minusNumCheck(preservedNum)) {
							// 계산 과정을 보여주는 텍스트가 비어있을 경우
							if (processLabel.getText().equals("")) {
								processLabel.setText("1/(" + preservedNum + ")");
								resultLabel.setText(String.valueOf((int) resultNum));
							}
							// 계산 과정을 보여주는 텍스트가 비어있지 않을 경우
							else {
								processLabel.setText("1/(" + processLabel.getText() + ")");
								resultLabel.setText(String.valueOf((int) resultNum));
							}
						}
						// 보존되는 값이 실수가 아닐경우
						else {
							// 계산 과정을 보여주는 텍스트가 비어있을 경우
							if (processLabel.getText().equals("")) {
								processLabel.setText("1/(" + (int) preservedNum + ")");
								resultLabel.setText(String.valueOf((int) resultNum));
							}
							// 계산 과정을 보여주는 텍스트가 비어있지 않을 경우
							else {
								processLabel.setText("1/(" + processLabel.getText() + ")");
								resultLabel.setText(String.valueOf((int) resultNum));
							}
						}
					}
				}
			}
			operCheck = true;
		}
	}

	// 결과 버튼을 눌렀을 경우 발생하는 이벤트(내부 클래스로 작성)(=)
	class ResultActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			preservedNum = 0;
			String[] textArr = processLabel.getText().split(" ");

			// 결과 과정을 보이는 텍스트에 +가 들어가있는 상태라면
			if (processLabel.getText().contains("+")) {
				// 배열의 길이가 2라면
				if (textArr.length == 2) {
					// =을 지금 처음 누른다는 의미와 동일하다
					// 그러므로 =을 계속 누르는 일이 발생할 경우 resultLabel에 있는 값을 계속 더해줘야 하기 때문에
					// 값을 보존해줘야 한다.
					if (operCheck == true) {
						// =을 누른뒤 숫자버튼을 누른다면 모두 다 초기화 되기때문에 값을 보존할 수 있다.
						preservedNum = Double.valueOf(resultLabel.getText());
					}

					double resultNum_double = 0;
					if (preservedNum == 0) {
						String textNum1 = textArr[0];
						resultNum_double = Double.valueOf(textNum1) + Double.valueOf(resultLabel.getText());
					} else {
						resultNum_double = Double.valueOf(resultLabel.getText()) + preservedNum;
					}

					// 결과값이 실수라면
					if (minusNumCheck(resultNum_double)) {
						// 보존되는 값이 실수라면
						if (minusNumCheck(preservedNum)) {
							if (preservedNum == 0) {
								String textNum1 = textArr[0];
								processLabel.setText(textNum1 + " + " + resultLabel.getText() + " = ");
								resultLabel.setText(String.valueOf(resultNum_double));
							} else {
								processLabel
										.setText(resultLabel.getText() + " + " + String.valueOf(preservedNum) + " = ");
								resultLabel.setText(String.valueOf(resultNum_double));
							}
						}
						// 보존되는 값이 실수가 아니라면
						else {
							if (preservedNum == 0) {
								String textNum1 = textArr[0];
								processLabel.setText(textNum1 + " + " + resultLabel.getText() + " = ");
								resultLabel.setText(String.valueOf(resultNum_double));
							} else {
								processLabel.setText(
										resultLabel.getText() + " + " + String.valueOf((int) preservedNum) + " = ");
								resultLabel.setText(String.valueOf(resultNum_double));
							}
						}
					}
					// 결과값이 정수라면
					else {
						int resultNum_int = (int) resultNum_double;
						// 보존되는 값이 실수라면
						if (minusNumCheck(preservedNum)) {
							if (preservedNum == 0) {
								String textNum1 = textArr[0];
								processLabel.setText(textNum1 + " + " + resultLabel.getText() + " = ");
								resultLabel.setText(String.valueOf(resultNum_int));
							} else {
								processLabel
										.setText(resultLabel.getText() + " + " + String.valueOf(preservedNum) + " = ");
								resultLabel.setText(String.valueOf(resultNum_int));
							}
						}
						// 보존되는 값이 실수가 아니라면
						else {
							if (preservedNum == 0) {
								String textNum1 = textArr[0];
								processLabel.setText(textNum1 + " + " + resultLabel.getText() + " = ");
								resultLabel.setText(String.valueOf(resultNum_int));
							} else {
								processLabel.setText(
										resultLabel.getText() + " + " + String.valueOf((int) preservedNum) + " = ");
								resultLabel.setText(String.valueOf(resultNum_int));
							}
						}
					}
				}
				// 배열의 길이가 2가 아니라면
				else {
					// 즉 =을 한번은 눌렀다는 의미와 동일하다
					// 그러므로 =을 계속 누를때마다 보존된 값을 계속 연산해주어야한다.

					String[] arr = processLabel.getText().split(" ");

					if (operCheck == true) {
						preservedNum = Double.valueOf(arr[2]);
					}

					double resultNum_double = Double.valueOf(resultLabel.getText()) + preservedNum;
					// 결과값이 실수라면
					if (minusNumCheck(resultNum_double)) {
						// 보존되는 값이 실수라면
						if (minusNumCheck(preservedNum)) {
							processLabel.setText(resultLabel.getText() + " + " + String.valueOf(preservedNum) + " = ");
							resultLabel.setText(String.valueOf(resultNum_double));
						}
						// 보존되는 값이 실수가 아니라면
						else {
							processLabel.setText(
									resultLabel.getText() + " + " + String.valueOf((int) preservedNum) + " = ");
							resultLabel.setText(String.valueOf(resultNum_double));
						}
					}
					// 결과값이 정수라면
					else {
						int resultNum_int = (int) resultNum_double;
						// 보존되는 값이 실수라면
						if (minusNumCheck(preservedNum)) {
							processLabel.setText(resultLabel.getText() + " + " + String.valueOf(preservedNum) + " = ");
							resultLabel.setText(String.valueOf(resultNum_int));
						}
						// 보존되는 값이 실수가 아니라면
						else {
							processLabel.setText(
									resultLabel.getText() + " + " + String.valueOf((int) preservedNum) + " = ");
							resultLabel.setText(String.valueOf(resultNum_int));
						}
					}
				}
			}
			// 결과 과정을 보이는 텍스트에 *가 들어가있는 상태라면
			else if (processLabel.getText().contains("*")) {
				// 배열의 길이가 2라면
				if (textArr.length == 2) {
					// =을 지금 처음 누른다는 의미와 동일하다
					// 그러므로 =을 계속 누르는 일이 발생할 경우 resultLabel에 있는 값을 계속 더해줘야 하기 때문에
					// 값을 보존해줘야 한다.
					if (operCheck == true) {
						// =을 누른뒤 숫자버튼을 누른다면 모두 다 초기화 되기때문에 값을 보존할 수 잇따.
						preservedNum = Double.valueOf(resultLabel.getText());
					}

					double resultNum_double = 0;
					if (preservedNum == 0) {
						String textNum1 = textArr[0];
						resultNum_double = Double.valueOf(textNum1) * Double.valueOf(resultLabel.getText());
					} else {
						resultNum_double = Double.valueOf(resultLabel.getText()) * preservedNum;
					}

					// 결과값이 실수라면
					if (minusNumCheck(resultNum_double)) {
						// 보존되는 값이 실수라면
						if (minusNumCheck(preservedNum)) {
							if (preservedNum == 0) {
								String textNum1 = textArr[0];
								processLabel.setText(textNum1 + " * " + resultLabel.getText() + " = ");
								resultLabel.setText(String.valueOf(resultNum_double));
							} else {
								processLabel
										.setText(resultLabel.getText() + " * " + String.valueOf(preservedNum) + " = ");
								resultLabel.setText(String.valueOf(resultNum_double));
							}
						}
						// 보존되는 값이 실수가 아니라면
						else {
							if (preservedNum == 0) {
								String textNum1 = textArr[0];
								processLabel.setText(textNum1 + " * " + resultLabel.getText() + " = ");
								resultLabel.setText(String.valueOf(resultNum_double));
							} else {
								processLabel.setText(
										resultLabel.getText() + " * " + String.valueOf((int) preservedNum) + " = ");
								resultLabel.setText(String.valueOf(resultNum_double));
							}
						}
					}
					// 결과값이 정수라면
					else {
						int resultNum_int = (int) resultNum_double;
						// 보존되는 값이 실수라면
						if (minusNumCheck(preservedNum)) {
							if (preservedNum == 0) {
								String textNum1 = textArr[0];
								processLabel.setText(textNum1 + " * " + resultLabel.getText() + " = ");
								resultLabel.setText(String.valueOf((int) resultNum_int));
							} else {
								processLabel
										.setText(resultLabel.getText() + " * " + String.valueOf(preservedNum) + " = ");
								resultLabel.setText(String.valueOf((int) resultNum_int));
							}
						}
						// 보존되는 값이 실수가 아니라면
						else {
							if (preservedNum == 0) {
								String textNum1 = textArr[0];
								processLabel.setText(textNum1 + " * " + resultLabel.getText() + " = ");
								resultLabel.setText(String.valueOf((int) resultNum_int));
							} else {
								processLabel.setText(
										resultLabel.getText() + " * " + String.valueOf((int) preservedNum) + " = ");
								resultLabel.setText(String.valueOf((int) resultNum_int));
							}
						}
					}
				}
				// 배열의 길이가 2가 아니라면
				else {
					// 즉 =을 한번은 눌렀다는 의미와 동일하다
					// 그러므로 =을 계속 누를때마다 보존된 값을 계속 연산해주어야한다.

					String[] arr = processLabel.getText().split(" ");

					if (operCheck == true) {
						preservedNum = Double.valueOf(arr[2]);
					}

					double resultNum_double = Double.valueOf(resultLabel.getText()) * preservedNum;
					// 결과값이 실수라면
					if (minusNumCheck(resultNum_double)) {
						// 보존되는 값이 실수라면
						if (minusNumCheck(preservedNum)) {
							processLabel.setText(resultLabel.getText() + " * " + String.valueOf(preservedNum) + " = ");
							resultLabel.setText(String.valueOf(resultNum_double));
						}
						// 보존되는 값이 실수가 아니라면
						else {
							processLabel.setText(
									resultLabel.getText() + " * " + String.valueOf((int) preservedNum) + " = ");
							resultLabel.setText(String.valueOf(resultNum_double));
						}
					}
					// 결과값이 정수라면
					else {
						int resultNum_int = (int) resultNum_double;
						// 보존되는 값이 실수라면
						if (minusNumCheck(preservedNum)) {
							processLabel.setText(resultLabel.getText() + " * " + String.valueOf(preservedNum) + " = ");
							resultLabel.setText(String.valueOf(resultNum_int));
						}
						// 보존되는 값이 실수가 아니라면
						else {
							processLabel.setText(
									resultLabel.getText() + " * " + String.valueOf((int) preservedNum) + " = ");
							resultLabel.setText(String.valueOf(resultNum_int));
						}
					}
				}
			}
			// 결과 과정을 보이는 텍스트에 /가 들어가있는 상태라면
			else if (processLabel.getText().contains("/")) {
				// 배열의 길이가 2라면
				if (textArr.length == 2) {
					// =을 지금 처음 누른다는 의미와 동일하다
					// 그러므로 =을 계속 누르는 일이 발생할 경우 resultLabel에 있는 값을 계속 더해줘야 하기 때문에
					// 값을 보존해줘야 한다.
					if (operCheck == true) {
						// =을 누른뒤 숫자버튼을 누른다면 모두 다 초기화 되기때문에 값을 보존할 수 있다.
						preservedNum = Double.valueOf(resultLabel.getText());
					}

					double resultNum_double = 0;
					if (preservedNum == 0) {
						String textNum1 = textArr[0];
						resultNum_double = Double.valueOf(textNum1) / Double.valueOf(resultLabel.getText());
					} else {
						resultNum_double = Double.valueOf(resultLabel.getText()) / preservedNum;
					}

					// 결과값이 실수라면
					if (minusNumCheck(resultNum_double)) {
						// 보존되는 값이 실수라면
						if (minusNumCheck(preservedNum)) {
							if (preservedNum == 0) {
								String textNum1 = textArr[0];
								processLabel.setText(textNum1 + " / " + resultLabel.getText() + " = ");
								resultLabel.setText(String.valueOf(resultNum_double));
							} else {
								processLabel
										.setText(resultLabel.getText() + " / " + String.valueOf(preservedNum) + " = ");
								resultLabel.setText(String.valueOf(resultNum_double));
							}
						}
						// 보존되는 값이 실수가 아니라면
						else {
							if (preservedNum == 0) {
								String textNum1 = textArr[0];
								processLabel.setText(textNum1 + " / " + resultLabel.getText() + " = ");
								resultLabel.setText(String.valueOf(resultNum_double));
							} else {
								processLabel.setText(
										resultLabel.getText() + " / " + String.valueOf((int) preservedNum) + " = ");
								resultLabel.setText(String.valueOf(resultNum_double));
							}
						}
					}
					// 결과값이 정수라면
					else {
						int resultNum_int = (int) resultNum_double;
						// 보존되는 값이 실수라면
						if (minusNumCheck(preservedNum)) {
							if (preservedNum == 0) {
								String textNum1 = textArr[0];
								processLabel.setText(textNum1 + " / " + resultLabel.getText() + " = ");
								resultLabel.setText(String.valueOf(resultNum_int));
							} else {
								processLabel
										.setText(resultLabel.getText() + " / " + String.valueOf(preservedNum) + " = ");
								resultLabel.setText(String.valueOf(resultNum_int));
							}
						}
						// 보존되는 값이 실수가 아니라면
						else {
							if (preservedNum == 0) {
								String textNum1 = textArr[0];
								processLabel.setText(textNum1 + " / " + resultLabel.getText() + " = ");
								resultLabel.setText(String.valueOf(resultNum_int));
							} else {
								processLabel.setText(
										resultLabel.getText() + " / " + String.valueOf((int) preservedNum) + " = ");
								resultLabel.setText(String.valueOf(resultNum_int));
							}
						}
					}
				}
				// 배열의 길이가 2가 아니라면
				else {
					// 즉 =을 한번은 눌렀다는 의미와 동일하다
					// 그러므로 =을 계속 누를때마다 보존된 값을 계속 연산해주어야한다.

					String[] arr = processLabel.getText().split(" ");

					if (operCheck == true) {
						preservedNum = Double.valueOf(arr[2]);
					}

					double resultNum_double = Double.valueOf(resultLabel.getText()) / preservedNum;
					// 결과값이 실수라면
					if (minusNumCheck(resultNum_double)) {
						// 보존되는 값이 실수라면
						if (minusNumCheck(preservedNum)) {
							processLabel.setText(resultLabel.getText() + " / " + String.valueOf(preservedNum) + " = ");
							resultLabel.setText(String.valueOf(resultNum_double));
						}
						// 보존되는 값이 실수가 아니라면
						else {
							processLabel.setText(
									resultLabel.getText() + " / " + String.valueOf((int) preservedNum) + " = ");
							resultLabel.setText(String.valueOf(resultNum_double));
						}
					}
					// 결과값이 정수라면
					else {
						int resultNum_int = (int) resultNum_double;
						// 보존되는 값이 실수라면
						if (minusNumCheck(preservedNum)) {
							processLabel.setText(resultLabel.getText() + " / " + String.valueOf(preservedNum) + " = ");
							resultLabel.setText(String.valueOf(resultNum_int));
						}
						// 보존되는 값이 실수가 아니라면
						else {
							processLabel.setText(
									resultLabel.getText() + " / " + String.valueOf((int) preservedNum) + " = ");
							resultLabel.setText(String.valueOf(resultNum_int));
						}
					}
				}
			}
			// 결과 과정을 보이는 텍스트에 -가 들어가있는 상태라면
			else if (processLabel.getText().contains("-")) {
				// 배열의 길이가 2라면
				if (textArr.length == 2) {
					// =을 지금 처음 누른다는 의미와 동일하다
					// 그러므로 =을 계속 누르는 일이 발생할 경우 resultLabel에 있는 값을 계속 더해줘야 하기 때문에
					// 값을 보존해줘야 한다.

					if (operCheck == true) {
						// =을 누른뒤 숫자버튼을 누른다면 모두 다 초기화 되기때문에 값을 보존할 수 있다.
						preservedNum = Double.valueOf(resultLabel.getText());
					}

					double resultNum_double = 0;
					if (preservedNum == 0) {
						String textNum1 = textArr[0];
						resultNum_double = Double.valueOf(textNum1) - Double.valueOf(resultLabel.getText());
					} else {
						resultNum_double = Double.valueOf(resultLabel.getText()) - preservedNum;
					}

					// 결과값이 실수라면
					if (minusNumCheck(resultNum_double)) {
						// 보존되는 값이 실수라면
						if (minusNumCheck(preservedNum)) {
							if (preservedNum == 0) {
								String textNum1 = textArr[0];
								processLabel.setText(textNum1 + " - " + resultLabel.getText() + " = ");
								resultLabel.setText(String.valueOf(resultNum_double));
							} else {
								processLabel
										.setText(resultLabel.getText() + " - " + String.valueOf(preservedNum) + " = ");
								resultLabel.setText(String.valueOf(resultNum_double));
							}
						}
						// 보존되는 값이 실수가 아니라면
						else {
							if (preservedNum == 0) {
								String textNum1 = textArr[0];
								processLabel.setText(textNum1 + " - " + resultLabel.getText() + " = ");
								resultLabel.setText(String.valueOf(resultNum_double));
							} else {
								processLabel
										.setText(resultLabel.getText() + " - " + String.valueOf(preservedNum) + " = ");
								resultLabel.setText(String.valueOf(resultNum_double));
							}
						}
					}
					// 결과값이 정수라면
					else {
						int resultNum_int = (int) resultNum_double;
						// 보존되는 값이 실수라면
						if (minusNumCheck(preservedNum)) {
							if (preservedNum == 0) {
								String textNum1 = textArr[0];
								processLabel.setText(textNum1 + " - " + resultLabel.getText() + " = ");
								resultLabel.setText(String.valueOf(resultNum_int));
							} else {
								processLabel
										.setText(resultLabel.getText() + " - " + String.valueOf(preservedNum) + " = ");
								resultLabel.setText(String.valueOf(resultNum_int));
							}
						}
						// 보존되는 값이 실수가 아니라면
						else {
							if (preservedNum == 0) {
								String textNum1 = textArr[0];
								processLabel.setText(textNum1 + " - " + resultLabel.getText() + " = ");
								resultLabel.setText(String.valueOf(resultNum_int));
							} else {
								processLabel.setText(
										resultLabel.getText() + " - " + String.valueOf((int) preservedNum) + " = ");
								resultLabel.setText(String.valueOf(resultNum_int));
							}
						}
					}
				}
				// 배열의 길이가 2가 아니라면
				else {
					// 즉 =을 한번은 눌렀다는 의미와 동일하다
					// 그러므로 =을 계속 누를때마다 보존된 값을 계속 연산해주어야한다.
					String[] arr = processLabel.getText().split(" ");

					if (operCheck == true) {
						preservedNum = Double.valueOf(arr[2]);
					}

					double resultNum_double = Double.valueOf(resultLabel.getText()) - preservedNum;
					// 결과값이 실수라면
					if (minusNumCheck(resultNum_double)) {
						// 보존되는 값이 실수라면
						if (minusNumCheck(preservedNum)) {
							String textNum1 = textArr[0];
							processLabel.setText(textNum1 + " - " + resultLabel.getText() + " = ");
							resultLabel.setText(String.valueOf(resultNum_double));
						}
						// 보존되는 값이 실수가 아니라면
						else {
							processLabel.setText(
									resultLabel.getText() + " - " + String.valueOf((int) preservedNum) + " = ");
							resultLabel.setText(String.valueOf(resultNum_double));
						}
					}
					// 결과값이 정수라면
					else {
						int resultNum_int = (int) resultNum_double;
						// 보존되는 값이 실수라면
						if (minusNumCheck(preservedNum)) {
							processLabel.setText(resultLabel.getText() + " - " + String.valueOf(preservedNum) + " = ");
							resultLabel.setText(String.valueOf(resultNum_int));
						}
						// 보존되는 값이 실수가 아니라면
						else {
							processLabel.setText(
									resultLabel.getText() + " - " + String.valueOf((int) preservedNum) + " = ");
							resultLabel.setText(String.valueOf(resultNum_int));
						}
					}
				}
			}
			// 결과 과정을 보이는 텍스트에 아무 수식도 들어가 있지 않은 상태라면
			else {
				String textNum = PointBackNull(resultLabel.getText());
				processLabel.setText(textNum + " = ");
				resultLabel.setText(textNum);
			}
			operCheck = true;
		}
	}

	// 문자열을 지우는 것과 관계되는 버튼을 눌렀을 경우 발생하는 이벤트(내브 클래스로 작성)(CE,C,Back)
	class EraseActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();

			// CE버튼을 선택했다면
			if (btn.getText().equals("CE")) {
				// 결과를 출력해주는 JLabel의 내용을 초기화해야한다.
				resultLabel.setText("0");
			}
			// C버튼을 선택했다면
			else if (btn.getText().equals("C")) {
				// 결과를 출력해주는 JLabel과 계산 과정을 나태나는 JLabel을 모두 초기화해야한다.
				resultLabel.setText("0");
				processLabel.setText("");
			}
			// Back버튼을 선택했다면
			else if (btn.getText().equals("Back")) {
				// 결과를 출력해주는 JLabel의 내용을 뒷부분을 삭제해야한다.
				String text = resultLabel.getText().substring(0, resultLabel.getText().length() - 1);
				if (text.length() == 0) {
					resultLabel.setText("0");
				} else {
					resultLabel.setText(text);
				}
			}
		}
	}

	// 메인
	public static void main(String[] args) {
		new CalculatorExam_JLabel_JButton();
	}
}