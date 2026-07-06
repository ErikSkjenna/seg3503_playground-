defmodule Grades.Calculator do
  @homework_weight 0.25
  @labs_weight 0.25
  @midterm_weight 0.20
  @final_weight 0.30

  def percentage_grade(grades) do
    homework_average = average(Map.get(grades, :homework, []))
    labs_average = average(Map.get(grades, :labs, []))
    midterm = to_number(Map.get(grades, :midterm, 0))
    final = to_number(Map.get(grades, :final, 0))

    percentage =
      homework_average * @homework_weight +
      labs_average * @labs_weight +
      midterm * @midterm_weight +
      final * @final_weight

    Float.round(percentage, 2)
  end

  def letter_grade(grades) do
    percentage_grade(grades)
    |> letter_from_percentage()
  end

  def numeric_grade(grades) do
    percentage_grade(grades)
    |> numeric_from_percentage()
  end

  defp average(values) do
    numbers =
      values
      |> Enum.map(&to_number/1)

    case numbers do
      [] -> 0.0
      _ -> Enum.sum(numbers) / length(numbers)
    end
  end

  defp to_number(nil), do: 0.0
  defp to_number(""), do: 0.0

  defp to_number(value) when is_integer(value), do: value * 1.0
  defp to_number(value) when is_float(value), do: value

  defp to_number(value) when is_binary(value) do
    value
    |> String.trim()
    |> String.replace("%", "")
    |> Float.parse()
    |> case do
      {number, _rest} -> clamp(number)
      :error -> 0.0
    end
  end

  defp to_number(_value), do: 0.0

  defp clamp(number) when number < 0, do: 0.0
  defp clamp(number) when number > 100, do: 100.0
  defp clamp(number), do: number

  defp letter_from_percentage(percentage) when percentage >= 90, do: "A+"
  defp letter_from_percentage(percentage) when percentage >= 85, do: "A"
  defp letter_from_percentage(percentage) when percentage >= 80, do: "A-"
  defp letter_from_percentage(percentage) when percentage >= 75, do: "B+"
  defp letter_from_percentage(percentage) when percentage >= 70, do: "B"
  defp letter_from_percentage(percentage) when percentage >= 65, do: "C+"
  defp letter_from_percentage(percentage) when percentage >= 60, do: "C"
  defp letter_from_percentage(percentage) when percentage >= 55, do: "D+"
  defp letter_from_percentage(percentage) when percentage >= 50, do: "D"
  defp letter_from_percentage(percentage) when percentage >= 40, do: "E"
  defp letter_from_percentage(_percentage), do: "F"

  defp numeric_from_percentage(percentage) when percentage >= 90, do: 10
  defp numeric_from_percentage(percentage) when percentage >= 85, do: 9
  defp numeric_from_percentage(percentage) when percentage >= 80, do: 8
  defp numeric_from_percentage(percentage) when percentage >= 75, do: 7
  defp numeric_from_percentage(percentage) when percentage >= 70, do: 6
  defp numeric_from_percentage(percentage) when percentage >= 65, do: 5
  defp numeric_from_percentage(percentage) when percentage >= 60, do: 4
  defp numeric_from_percentage(percentage) when percentage >= 55, do: 3
  defp numeric_from_percentage(percentage) when percentage >= 50, do: 2
  defp numeric_from_percentage(percentage) when percentage >= 40, do: 1
  defp numeric_from_percentage(_percentage), do: 0
end