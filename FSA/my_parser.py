from automata import Automata


class Parser(object):
    """Class Parser parse input and create Automata."""

    def __init__(self):
        pass

    def parse_automata(self, in_file):
        """ :return Automata that contains in in_file"""

        states = self.__init_states(in_file)
        alphabet = self.__init_alphabet(in_file)

        init_state = states[
            (in_file.readline())[:-1]
        ]

        self.__init_final_states(in_file, states)
        self.__init_transitions(in_file, states)

        return Automata(states, alphabet, init_state)

    def __next_elements(self, in_file):
        """:return list of elements which contains on file's next line"""

        str = in_file.readline()
        return (str[1:-2]).split(',')

    def __init_states(self, in_file):
        """:return list of states that contains on file's next line"""

        states_names_list = self.__next_elements(in_file)
        states = {}

        for state_name in states_names_list:
            state = Automata.State(state_name, False, {})
            states[state_name] = state

        return states

    def __init_alphabet(self, in_file):
        """:return list of letters that contains on file's next line"""

        return self.__next_elements(in_file)

    def __init_final_states(self, in_file, states):
        final_states_names_list = self.__next_elements(in_file)

        for state_name in final_states_names_list:
            state = states[state_name]
            state.is_final = True

    def __init_transitions(self, in_file, states):
        transitions_list = self.__next_elements(in_file)

        for transition_name in transitions_list:
            # Recognize each transition like "state0(letter)->state1"
            # and append it to state0 transitions hash table.

            open_parenthesis_index = transition_name.index('(')
            close_parenthesis_index = transition_name.index(')')

            state_from_name = transition_name[:open_parenthesis_index]
            state_to_name = transition_name[close_parenthesis_index + 3:]

            letter = transition_name[open_parenthesis_index + 1: close_parenthesis_index]

            state_from = states[state_from_name]
            state_to = states[state_to_name]

            transitions = state_from.transitions
            transitions[letter] = state_to
