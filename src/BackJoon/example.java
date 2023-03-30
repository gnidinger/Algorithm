package BackJoon;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class example {
	public static void main(String[] args) {

		System.out.println(LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)));
		System.out.println(LocalDateTime.now());

	}
}