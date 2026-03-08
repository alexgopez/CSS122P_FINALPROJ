class Buyer:
    def __init__(self, name, profession):
        self.Name = name
        self.Profession = profession
        self.Payment_option = None
        self.Acquired_property = []
        self.TCP = 0.0
        self.Transactions = []
        self.Remaining = 0.0

    def set_payment_option(self, payment_option):
        self.Payment_option = payment_option

    def add_property(self, lot):
        self.Acquired_property.append(lot)
        if self.Payment_option:
            self.TCP += self.Payment_option.compute_tcp(lot.price)
            self.Remaining += self.Payment_option.compute_tcp(lot.price)

    def add_transaction(self, transaction):
        self.Transactions.append(transaction)
        self.Remaining -= transaction.amount

    def update_remaining(self, amount):
        self.Remaining = amount

    def get_info(self):
        info = {
            'Name': self.Name,
            'Profession': self.Profession,
            'Payment Option': type(self.Payment_option).__name__ if self.Payment_option else None,
            'Acquired Property': [lot.lot_id for lot in self.Acquired_property],
            'TCP': self.TCP,
            'Remaining': self.Remaining,
            'Transactions': [t.transaction_id for t in self.Transactions]
        }
        return info
