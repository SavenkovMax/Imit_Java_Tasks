package second;

import java.util.Arrays;
import java.util.Objects;

public class IncomeCertificate {
    private final int year;
    private final String citizen;
    private final String organization;
    private final int[] amounts;

    public IncomeCertificate(String citizen, String organization, int year, int[] amounts) {
        if (citizen == null) {
            throw new IllegalArgumentException("The string citizen is null");
        }
        if (organization == null) {
            throw new IllegalArgumentException("The string organization is null");
        }
        if (amounts == null) {
            throw new IllegalArgumentException("The amounts array is null");
        }
        if (amounts.length != 12) {
            throw new IllegalArgumentException("The amounts count must be 12");
        }
        this.year = year;
        this.citizen = citizen;
        this.organization = organization;
        this.amounts = new int[amounts.length];
        System.arraycopy(amounts, 0, this.amounts, 0, amounts.length);
    }

    public IncomeCertificate(final IncomeCertificate certificate) {
        this.year = certificate.year;
        this.citizen = certificate.citizen;
        this.organization = certificate.organization;
        this.amounts = new int[12];
        System.arraycopy(certificate.amounts, 0, this.amounts, 0, 12);
    }

    public int getYear() {
        return year;
    }

    public String getCitizen() {
        return citizen;
    }

    public String getOrganization() {
        return organization;
    }

    public int[] getAmounts() {
        int[] income = new int[12];
        System.arraycopy(amounts, 0, income, 0, 12);
        return income;
    }

    @Override
    public String toString() {
        String title = String.format("Справка о полученных доходах\nГод: %d\nГражданин: %s\nОрганизация: %s\n" +
                "Полученный доход:\nМесяц\tСумма, руб.\n", year, citizen, organization);
        StringBuilder text = new StringBuilder(title);
        String month;
        for (int i = 0; i < amounts.length; i++) {
            if ((i + 1) / 10 == 0) {
                month = String.format("0%d", i + 1);
            } else {
                month = String.format("%d", i + 1);
            }
            text.append(String.format("%s\t\t\t%d\n", month, amounts[i]));
        }
        return new String(text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IncomeCertificate)) return false;
        IncomeCertificate that = (IncomeCertificate) o;
        return getYear() == that.getYear() && Objects.equals(getCitizen(), that.getCitizen())
                && Objects.equals(getOrganization(), that.getOrganization())
                && Arrays.equals(amounts, that.amounts);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getYear(), getCitizen(), getOrganization());
        result = 31 * result + Arrays.hashCode(amounts);
        return result;
    }
}
