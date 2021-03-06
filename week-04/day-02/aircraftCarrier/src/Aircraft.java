public class Aircraft {
  private int maxAmmo;
  private int baseDamage;
  private int ammo;

  public Aircraft(int maxAmmo, int baseDamage) {
    this.maxAmmo = maxAmmo;
    this.baseDamage = baseDamage;
    this.ammo = 0;
  }

  public int fight() {
    int damage = this.ammo * this.baseDamage;
    this.ammo = 0;
    return damage;
  }

  public int refill(int ammoIn) {
    if (ammoIn < maxAmmo - ammo) {
      ammo += ammoIn;
      return 0;
    }
    else {
      int defic = maxAmmo - ammo;
      ammo = maxAmmo;
      return ammoIn - defic;
    }
  }

  public String getType() {
    return this.getClass().toString();
  }

  public int countDamage() {
    return this.ammo * this.baseDamage;
  }

  public String getStatus() {
    return "Type " + this.getClass() + ", Ammo: " + this.ammo + ", Base Damage: "
            + this.baseDamage + ", All Damage: " + this.countDamage();
  }
}
