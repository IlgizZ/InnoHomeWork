"""
    Class Automata represent FSA.
    That has states list, initial state, alphabet
    and inner class State.
    Each state represented by name, is_final field and
    transitions hash table which transit to other state
    by letter.
"""
class Automata(object):
    class State(object):
        def __init__(self, name, is_final, transitions):
            self.name = name
            self.is_final = is_final
            self.transitions = transitions

    def __init__(self, states, alphabet, init_state):
        self.states = states
        self.alphabet = alphabet
        self.init_state = init_state
        print self

    def check_word(self, word):
        """
        :return string that consist  True or False is word
        can be recognized by Automata and path of states which
        automato go through.
        """
        state = self.init_state
        path = state.name

        for letter in word:
            state = state.transitions[letter]
            path += '->' + state.name

        return str(state.is_final) + ',' + path
