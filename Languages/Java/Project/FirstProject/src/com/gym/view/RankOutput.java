package com.gym.view;

import java.util.ArrayList;
import java.util.List;

import com.gym.service.UserService;
import com.gym.vo.GymVO;


public class RankOutput {
	private UserService service;

	public RankOutput() {
		this.service = new UserService();
	}

	public void rankVisit() {
		List<GymVO> list = this.service.rankVisit();
		List<GymVO> temp = new ArrayList<GymVO>();
		GymVO e = new GymVO();
		e.setAge(1);
		temp.add(e);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTchul() != 0) {
				list.get(i).setRankchul((list.get(i).getTchul() * 100 / (Integer.parseInt(list.get(i).getGap()))));
			}
		}
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size() - 1 - i; j++) {
				if (list.get(j).getRankchul() < list.get(j + 1).getRankchul()) {
					temp.set(0, list.get(j + 1));
					list.set(j + 1, list.get(j));
					list.set(j, temp.get(0));
				}
			}
		}
		int i = 0;
		System.out.println("\t" + "회원 번호" + "\t" + "이름" + "\t" + "출석율");
		for (GymVO g : list) {
			i++;
			System.out.print(i + "등\t");
			System.out.print(g.getNum() + "\t");
			System.out.print(g.getName().substring(0, 1) + "**" + "\t");
			System.out.println(g.getRankchul());
		}
	}
}
