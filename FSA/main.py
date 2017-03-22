from my_parser import Parser


def main():
    """
    Main method that open and close files
    and ckecks the belonging of word to language defined
    by the automata.
    """
    in_file_name = "input.txt"
    out_file_name = "output.txt"

    in_file = open(in_file_name, 'r')

    out_file = open(out_file_name, 'w')
    out_file.write('IlgizZamaleev' + '\n')

    problems = int(in_file.readline())

    for i in range(problems):
        automato = Parser().parse_automata(in_file)

        tests = int(in_file.readline())

        out_file.write(str(i + 1) + '\n')

        for j in range(tests):
            word = in_file.readline()[:-1]
            out_file.write(automato.check_word(word) + '\n')

    in_file.close()
    out_file.close()


if __name__ == "__main__":
    main()
