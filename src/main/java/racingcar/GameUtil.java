package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class GameUtil {

    public void printWinner(List<Racer> winners) {
        System.out.print("최종 우승자 : ");
        List<String> winnerNames = winners.stream()
                .map(Racer::getName)
                .toList();
        System.out.println(String.join(", ", winnerNames));
    }

    public void printEachResult(List<Racer> racerList) {
        StringBuilder result = new StringBuilder();
        for (Racer racer : racerList) {
            result.append(String.format("%5s : ", racer.getName()))
                    .append(racer.getScore())
                    .append("\n");
        }
        System.out.println(result.toString());
    }

    public String[] inputToNameArr(String input) {
        String[] nameArr = input.split(",");
        for (String name : nameArr) {
            if (!isNameOK(name)) {
                throw new IllegalArgumentException("이름은 한 글자 이상 다섯 글자 이하여야 합니다.");
            }
        }
        return nameArr;
    }

    /**
     * 이름이 1자리 이상 5자리 이하인지 확인하는 함수
     *
     * @param nameCandidate 전달받은 이름
     * @return boolean true or false
     */
    private boolean isNameOK(String nameCandidate) {
        return !nameCandidate.isEmpty() && nameCandidate.length() <= 5;
    }


}
